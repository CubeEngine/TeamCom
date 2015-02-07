/**
 * The MIT License
 * Copyright (c) 2013 Cube Island
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package de.cubeisland.teamcom.query;

import de.cubeisland.teamcom.query.command.*;
import de.cubeisland.teamcom.query.exception.*;
import de.cubeisland.teamcom.query.value.EventMode;
import de.cubeisland.teamcom.util.StringUtils;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import static de.cubeisland.teamcom.query.QueryConnectionBuilder.NO_DEFAULT_VIRTUAL_SERVER;
import static de.cubeisland.teamcom.query.property.ClientProperty.CLIENT_NICKNAME;
import static de.cubeisland.teamcom.query.value.EventMode.CHANNEL;
import static de.cubeisland.teamcom.query.Response.parseLine;
import static java.lang.Integer.parseInt;

/**
 * JTS3ServerQuery
 * Allows connecting to the Teamspeak 3 Query Interface and executing commands
 */
public class QueryConnection implements Closeable
{
    public static final String UTF_8 = "UTF-8";

    private final InetAddress address;
    private final int queryPort;
    private final int fileTransferPort;

    private final String username;
    private final String password;
    private final int defaultVirtualServer;
    private final Integer timeout;


    private Socket socketQuery = null;
    private BufferedReader in = null;
    private PrintStream out = null;

    private boolean queryInProcess = false;

    private ActionListener listener = null;
    private Timer eventNotifyTimer = null;
    private TimerTask eventNotifyTimerTask = null;

    private QueryCurrent queryCurrent;

    private final AtomicInteger downloadCounter = new AtomicInteger(0);

    public QueryConnection(InetAddress address, int queryPort, int fileTransferPort, String username, String password, int defaultVirtualServer, Integer timeout)
    {
        this.address = address;
        this.queryPort = queryPort;
        this.fileTransferPort = fileTransferPort;
        this.username = username;
        this.password = password;
        this.defaultVirtualServer = defaultVirtualServer;
        this.timeout = timeout;
    }

    public QueryCurrent current()
    {
        return queryCurrent;
    }

    /**
     * Query Information about a permission ID.
     *
     * @param permID A permission ID
     *
     * @return the permission or null if not found
     */
    public Permission getPermission(int permID) throws TeamComException
    {
        for (Map<String, String> permInfo : this.build(PermissionList.class).execute().asMapList())
        {
            if (parseInt(permInfo.get("permid")) == permID)
            {
                return new Permission(permID, permInfo.get("permname"), permInfo.get("permdesc"));
            }
        }
        return null;
    }

    /**
     * Change the display name on the Teamspeak 3 server of this query connection.
     * <br>This name will be displayed on many actions like kickClient(), moveClient(), pokeClient() and sendTextMessage().
     *
     * @param displayName A String with the new display name of this connection.
     */
    public void setDisplayName(String displayName) throws TeamComException
    {
        if (displayName == null || displayName.length() < 3)
        {
            throw new IllegalArgumentException("DisplayName null or shorter than 3 characters!");
        }
        try
        {
            this.build(ClientUpdate.class).property(CLIENT_NICKNAME, displayName).execute();
        }
        catch (Exception e)
        {
            throw new TeamComException("Exception while setting displayname", e);
        }
    }

    /**
     * Open a query connection to the TS3 server, you can set a local IP and port to bind the socket to it.
     */
    private void connect() throws TeamComException
    {
        try  // Open socket connection to TS3 telnet port
        {
            socketQuery = new Socket(address, queryPort);
        }
        catch (IOException e)
        {
            socketQuery = null;
            throw new NetworkingException("Exception while connecting", e);
        }
        if (!socketQuery.isConnected())
        {
            try
            {
                socketQuery.close();
            }
            catch (IOException ignored)
            {
            }
            socketQuery = null;
            throw new NotConnectedException();
        }
        try
        {
            in = new BufferedReader(new InputStreamReader(socketQuery.getInputStream(), UTF_8));
            out = new PrintStream(socketQuery.getOutputStream(), true, UTF_8);
            try
            {
                // Read Welcome Message...
                socketQuery.setSoTimeout(5000);
                boolean first = true;
                String read;
                while ((read = in.readLine()) != null)
                {
                    if (first)
                    {
                        if (!read.equals("TS3"))
                        {
                            throw new TeamComException("Server does not respond as TS3 server!");
                        }
                        first = false;
                        socketQuery.setSoTimeout(500);
                    }
                    // log("< " + read);
                }
            }
            catch (SocketTimeoutException ignored)
            {
            }

            socketQuery.setSoTimeout(timeout);


            if (username != null)
            {
                build(Login.class).with(username, password).execute();
            }
            if (defaultVirtualServer != NO_DEFAULT_VIRTUAL_SERVER)
            {
                build(Use.class).serverId(defaultVirtualServer).execute();
            }
        }
        catch (IOException e)
        {
            try
            {
                close();
            }
            catch (IOException ignore)
            {}
            throw new TeamComException("Error after connecting", e);
        }
        initNotifyTimer();
    }

    public void updateCurrent() throws TeamComException
    {
        Map<String, String> map = build(WhoAmI.class).execute().asMap();
        this.queryCurrent = new QueryCurrent(parseInt(map.get("client_id")),
                         parseInt(map.get("virtualserver_id")),
                         parseInt(map.get("client_channel_id")), null,
                         parseInt(map.get("client_database_id")));
    }

    public <T extends Command> T build(Class<T> clazz)
    {
        try
        {
            T command = clazz.newInstance();
            command.setConnection(this);
            return command;
        }
        catch (InstantiationException e)
        {
            throw new IllegalArgumentException(e);
        }
        catch (IllegalAccessException e)
        {
            throw new IllegalArgumentException(e);
        }
    }

    private void initNotifyTimer()
    {
        if (eventNotifyTimer != null)
        {
            eventNotifyTimer.cancel();
            eventNotifyTimer = null;
        }
        if (eventNotifyTimerTask != null)
        {
            eventNotifyTimerTask.cancel();
            eventNotifyTimerTask = null;
        }
        eventNotifyTimer = new Timer(true);
    }

    private void eventNotifyRun()
    {
        if (queryInProcess && isConnected())
        {
            try
            {
                if (in.ready())
                {
                    handleAction(readIncomingLine());
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    /**
     * Set a class that should receive the Teamspeak events. This class must implement the TeamspeakActionListener interface.
     *
     * @param listenerClass - A class that implements the TeamspeakActionListener interface.
     */
    public void setListener(ActionListener listenerClass)
    {
        this.listener = listenerClass;
    }

    /**
     * Remove the class from receiving Teamspeak events. This function also call removeAllEvents(), if needed.
     */
    public void removeListener() throws TeamComException
    {
        removeAllEvents();
        this.listener = null;
    }

    /**
     * Activate a Teamspeak event notify.<br><br>
     * <b>Notice:</b><br>
     * You have to use setListener() first!
     *
     * @param eventMode Use an EVENT_MODE constant
     * @param channelID A channel ID, only needed for CHANNEL. Use any number for any other EVENT_MODE.
     */
    public void addEventNotify(EventMode eventMode, int channelID) throws TeamComException
    {
        if (listener == null)
        {
            throw new IllegalStateException("TeamspeakActionListener not registered!");
        }
        try
        {
            if (eventMode == CHANNEL)
            {
                build(ServerNotifyRegister.class).eventChannel(eventMode, channelID).execute();
            }
            else
            {
                build(ServerNotifyRegister.class).event(eventMode).execute();
            }
        }
        catch (Exception e)
        {
            throw new TeamComException("Exception while adding event", e);
        }
        if (eventNotifyTimerTask == null)
        {
            eventNotifyTimerTask = new TimerTask()
            {
                public void run()
                {
                    eventNotifyRun();
                }
            };
            eventNotifyTimer.schedule(eventNotifyTimerTask, 200, 200);
        }
    }

    /**
     * Removes all activated events.
     */
    public void removeAllEvents() throws TeamComException
    {
        if (eventNotifyTimerTask != null)
        {
            try
            {
                build(ServerNotifyUnregister.class).execute();
            }
            catch (Exception e)
            {
                throw new TeamComException("Exception while removing all events", e);
            }
            eventNotifyTimerTask.cancel();
            eventNotifyTimerTask = null;
        }
    }


    /**
     * Close the query connection. Check getLastError() if any error occurred.
     */
    public void close() throws IOException
    {
        if (eventNotifyTimerTask != null)
        {
            eventNotifyTimerTask.cancel();
            eventNotifyTimerTask = null;
            eventNotifyTimer.cancel();
            eventNotifyTimer = null;
        }

        queryCurrent = null;

        if (out != null)
        {
            out.println("quit");
            out.close();
            out = null;
            // log("> quit");
        }

        if (in != null)
        {
            in.close();
            in = null;
        }

        if (socketQuery != null)
        {
            socketQuery.close();
            socketQuery = null;
        }
    }

    public final synchronized String executeRawCommand(String command) throws TeamComException
    {
        ensureConnected();
        this.queryInProcess = false;
        // log("> " + command);
        out.println(command);
        // Read Incoming...
        if (!isConnected())
        {
            throw new NotConnectedException();
        }
        LinkedList<String> lines = new LinkedList<String>();
        try
        {
            String read;
            while ((read = readIncomingLine()) != null)
            {
                if (read.length() > 0 && (!read.startsWith("notify") || !handleAction(read)))
                {
                    lines.add(read);
                    if (read.startsWith("error "))
                    {
                        break;
                    }
                }
            }
            if (lines.isEmpty())
            {
                close();
                throw new TeamComException("No Response, maybe connection to TS3 server got interrupted.");
            }
            // Creates a map with the parsed error id and message.
            Map<String, String> map = parseLine(lines.getLast());
            lines.removeLast();
            if (!map.get("id").equals("0"))
            {
                throw ServerErrorException.forResponse(map);
            }
            return StringUtils.explode(lines);
        }
        catch (IOException e)
        {
            try
            {
                close();
            }
            catch (IOException ignored)
            {}
            throw new TeamComException("Connection to TS3 Server interrupted!", e);
        }
        finally
        {
            queryInProcess = true;
        }
    }

    /**
     * Check if connected to the TS3 server.
     *
     * @return <code>true</code> if connected, <code>false</code> if not.
     */
    public boolean isConnected()
    {
        if (socketQuery == null || in == null || out == null)
        {
            return false;
        }
        return socketQuery.isConnected();
    }

    private void ensureConnected() throws TeamComException
    {
        if (!isConnected())
        {
            this.connect();
        }
    }

    private String readIncomingLine() throws IOException
    {
        String read = in.readLine();
        if (read != null && read.length() > 0) // Don't bother logging nothing
        {
            // log("< " + read);
        }
        return read;
    }

    private boolean handleAction(final String actionLine)
    {
        if (actionLine.length() == 0)
        {
            return false;
        }
        if (listener != null)
        {
            final int pos = actionLine.indexOf(" ");
            if (pos != -1)
            {
                Thread t = new Thread(new Runnable()
                {
                    public void run()
                    {
                        try
                        {
                            String eventType = actionLine.substring(0, pos);
                            String eventData = actionLine.substring(pos + 1);
                            listener.listen(eventType, parseLine(eventData));
                        }
                        catch (Exception e)
                        {
                            e.printStackTrace();
                        }
                    }
                });
                t.setName("handleAction");
                t.start();
            }
        }
        return true;
    }

    public FileTransfer downloadIcon(long id) throws TeamComException
    {
        return downloadFile("/icon_" + id, 0, null);
    }

    public FileTransfer downloadFile(String path, int channel, String channelPassword) throws TeamComException
    {
        try
        {
            downloadCounter.compareAndSet(0xFFFF, 0);
            System.out.println("Getting icon #" + path);
            final Command c = build(FtInitDownload.class).init(downloadCounter.getAndIncrement(), path, channel, channelPassword, 0);
            Map<String, String> parsedResponse = c.execute().asMap();
            String ftkey = parsedResponse.get("ftkey");
            if (ftkey != null)
            {
                final Socket socket = new Socket(address, fileTransferPort);
                socket.getOutputStream().write((ftkey + "\n").getBytes("ASCII"));
                socket.setSoTimeout(2000);

                return new FileTransfer(socket.getInputStream(), parseInt(parsedResponse.get("size")));
            }
            else
            {
                throw new FileTransferException("File transfer initialization did not return a key");
            }
        }
        catch (IOException e)
        {
            throw new NetworkingException(e.getMessage(), e);
        }
    }

    public static final class FileTransfer implements Closeable
    {
        private final InputStream stream;
        private final int size;

        public FileTransfer(InputStream stream, int size)
        {
            this.stream = stream;
            this.size = size;
        }

        public InputStream getStream()
        {
            return stream;
        }

        public int getSize() {
            return size;
        }

        public void close() throws IOException
        {
            this.stream.close();
        }
    }

    public static class QueryCurrent
    {
        private final int clientId;
        private final int serverId;
        private final int channelId;
        private String channelPassword;
        private final int clientDbId;

        private QueryCurrent(int clientId, int serverId, int channelId, String channelPassword, int clientDbId)
        {
            this.clientId = clientId;
            this.serverId = serverId;
            this.channelId = channelId;
            this.channelPassword = channelPassword;
            this.clientDbId = clientDbId;
        }

        public boolean isClient(Object clientId)
        {
            return clientId != null && clientId.equals(this.clientId);
        }

        public boolean isInChannel(Object channelId)
        {
            return channelId != null && channelId.equals(this.channelId);
        }

        public boolean isOnServer(Object serverId)
        {
            return serverId != null && serverId.equals(this.serverId);
        }

        public void chooseServer(Integer serverId, QueryConnection query) throws TeamComException
        {
            if (serverId == null)
            {
                query.build(Use.class).serverId(this.serverId).execute();
            }
            else
            {
                query.build(Use.class).serverId(serverId).execute();
            }
        }

        public void moveToChannel(Integer channel, QueryConnection query) throws TeamComException
        {
            if (channel == null)
            {
                query.build(ClientMove.class).move(this.channelId, this.channelPassword, this.clientId).execute();
            }
            else
            {
                query.build(ClientMove.class).move(channel, null, this.clientId).execute();
            }
        }

        public void updateChannel(Integer cid, String cpw, QueryConnection query)
        {
            query.queryCurrent = new QueryCurrent(this.clientId,
                                                  this.serverId,
                                                 cid, cpw,
                                                 this.clientDbId);
        }
    }

}

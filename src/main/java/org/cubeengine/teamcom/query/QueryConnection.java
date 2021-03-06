/*
 * The MIT License
 * Copyright © 2013 Cube Island
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
package org.cubeengine.teamcom.query;

import org.cubeengine.teamcom.query.command.ClientMove;
import org.cubeengine.teamcom.query.command.FtInitDownload;
import org.cubeengine.teamcom.query.command.Login;
import org.cubeengine.teamcom.query.command.PermissionList;
import org.cubeengine.teamcom.query.command.ServerNotifyRegister;
import org.cubeengine.teamcom.query.command.ServerNotifyUnregister;
import org.cubeengine.teamcom.query.command.Use;
import org.cubeengine.teamcom.query.command.WhoAmI;
import org.cubeengine.teamcom.query.exception.FileTransferException;
import org.cubeengine.teamcom.query.exception.NetworkingException;
import org.cubeengine.teamcom.query.exception.NotConnectedException;
import org.cubeengine.teamcom.query.exception.ServerErrorException;
import org.cubeengine.teamcom.query.exception.TeamComException;
import org.cubeengine.teamcom.query.value.EventMode;
import org.cubeengine.teamcom.util.StringUtils;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.LinkedList;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Integer.parseInt;
import static org.cubeengine.teamcom.query.QueryConnectionBuilder.NO_DEFAULT_VIRTUAL_SERVER;
import static org.cubeengine.teamcom.query.Response.parseLine;
import static org.cubeengine.teamcom.query.value.EventMode.CHANNEL;

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

    public QueryCurrent getCurrent()
    {
        return queryCurrent;
    }

    public void updateCurrent() throws TeamComException
    {
        Map<String, String> map = build(WhoAmI.class).execute().asMap();
        this.queryCurrent = new QueryCurrent(parseInt(map.get("client_id")),
                parseInt(map.get("virtualserver_id")),
                parseInt(map.get("client_channel_id")), null,
                parseInt(map.get("client_database_id")));
    }

    /**
     * Query Information about a permission ID.
     *
     * @param permID A permission ID
     *
     * @throws TeamComException if the command could not be executed
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
                    //Example banned: error id=3329 msg=connection\sfailed,\syou\sare\sbanned extra_msg=you\smay\sretry\sin\s354\sseconds\n\r
                    if (read.contains("error id=3329"))
                    {
                        throw new TeamComException("You were banned for: " + read.substring(read.indexOf("in")).trim());
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
     *
     * @throws TeamComException if the underlying command could not be executed
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
     *
     * @throws TeamComException of the underlying command could not be executed
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
     *
     * @throws TeamComException if the underlying command could not be executed
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

    public void stopListener()
    {
        try
        {
            removeListener();
        }
        catch (TeamComException ignored)
        {}
        if (eventNotifyTimerTask != null)
        {
            eventNotifyTimerTask.cancel();
            eventNotifyTimerTask = null;
            eventNotifyTimer.cancel();
            eventNotifyTimer = null;
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
                socket.setSoTimeout(10000);

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

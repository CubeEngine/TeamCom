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
package de.cubeisland.teamcom.query.property;

import de.cubeisland.teamcom.query.Property;

import java.util.HashSet;
import java.util.Set;

public enum ClientProperty implements Property
{
    /**
     * Unique ID of the client
     */
    CLIENT_UNIQUE_IDENTIFIER(false),

    /**
     * Nickname of the client
     */
    CLIENT_NICKNAME(true), // TODO displayName.length() < 3)

    /**
     * Client version information including build number
     */
    CLIENT_VERSION(false),

    /**
     * Operating system the client is running on
     */
    CLIENT_PLATFORM(false),

    /**
     * Indicates whether the client has their microphone muted or not
     */
    CLIENT_INPUT_MUTED(false),

    /**
     * Indicates whether the client has their speakers muted or not
     */
    CLIENT_OUTPUT_MUTED(false),

    /**
     * Indicates whether the client has enabled their capture device or not
     */
    CLIENT_INPUT_HARDWARE(false),

    /**
     * Indicates whether the client has enabled their playback device or not
     */
    CLIENT_OUTPUT_HARDWARE(false),

    /**
     * Default channel of the client
     */
    CLIENT_DEFAULT_CHANNEL(false),

    /**
     * Username of a ServerQuery client
     */
    CLIENT_LOGIN_NAME(false),

    /**
     * Database ID of the client
     */
    CLIENT_DATABASE_ID(false),

    /**
     * Current channel group ID of the client
     */
    CLIENT_CHANNEL_GROUP_ID(false),

    /**
     * Current server group IDs of the client separated by a comma
     */
    CLIENT_SERVER_GROUPS(false),

    /**
     * Creation date and time of the clients first connection to the server as UTC timestamp
     */
    CLIENT_CREATED(false),

    /**
     * Creation date and time of the clients last connection to the server as UTC timestamp
     */
    CLIENT_LASTCONNECTED(false),

    /**
     * Total number of connections from this client since the server was started
     */
    CLIENT_TOTALCONNECTIONS(false),

    /**
     * Indicates whether the client is away or not
     */
    CLIENT_AWAY(false),

    /**
     * Away message of the client
     */
    CLIENT_AWAY_MESSAGE(false),

    /**
     * Indicates whether the client is a ServerQuery client or not
     */
    CLIENT_TYPE(false),

    /**
     * Indicates whether the client has set an avatar or not
     */
    CLIENT_FLAG_AVATAR(false),

    /**
     * The clients current talk power
     */
    CLIENT_TALK_POWER(false),

    /**
     * Indicates whether the client is requesting talk power or not
     */
    CLIENT_TALK_REQUEST(false),

    /**
     * The clients current talk power request message
     */
    CLIENT_TALK_REQUEST_MSG(false),

    /**
     * Indicates whether the client is able to talk or not
     */
    CLIENT_IS_TALKER(true),

    /**
     * Number of bytes downloaded by the client on the current month
     */
    CLIENT_MONTH_BYTES_DOWNLOADED(false),

    /**
     * Number of bytes uploaded by the client on the current month
     */
    CLIENT_MONTH_BYTES_UPLOADED(false),

    /**
     * Number of bytes downloaded by the client since the server was started
     */
    CLIENT_TOTAL_BYTES_DOWNLOADED(false),
    /**
     * Number of bytes uploaded by the client since the server was started
     */
    CLIENT_TOTAL_BYTES_UPLOADED(false),

    /**
     * Indicates whether the client is a priority speaker or not
     */
    CLIENT_IS_PRIORITY_SPEAKER(false),

    /**
     * Number of unread offline messages in this clients inbox
     */
    CLIENT_UNREAD_MESSAGES(false),

    /**
     * Phonetic name of the client
     */
    CLIENT_NICKNAME_PHONETIC(false),

    /**
     * Brief description of the client
     */
    CLIENT_DESCRIPTION(true),

    /**
     * The clients current ServerQuery view power
     */
    CLIENT_NEEDED_SERVERQUERY_VIEW_POWER(false),

    /**
     * Current bandwidth used for outgoing file transfers (Bytes/s)
     */
    CONNECTION_FILETRANSFER_BANDWIDTH_SENT(false),

    /**
     * Current bandwidth used for incoming file transfers (Bytes/s)
     */
    CONNECTION_FILETRANSFER_BANDWIDTH_RECEIVED(false),

    /**
     * Total amount of packets sent
     */
    CONNECTION_PACKETS_SENT_TOTAL(false),

    /**
     * Total amount of packets received
     */
    CONNECTION_PACKETS_RECEIVED_TOTAL(false),

    /**
     * Total amount of bytes sent
     */
    CONNECTION_BYTES_SENT_TOTAL(false),

    /**
     * Total amount of bytes received
     */
    CONNECTION_BYTES_RECEIVED_TOTAL(false),

    /**
     * Average bandwidth used for outgoing data in the last second (Bytes/s)
     */
    CONNECTION_BANDWIDTH_SENT_LAST_SECOND_TOTAL(false),

    /**
     * Average bandwidth used for incoming data in the last second (Bytes/s)
     */
    CONNECTION_BANDWIDTH_RECEIVED_LAST_SECOND_TOTAL(false),

    /**
     * Average bandwidth used for outgoing data in the last minute (Bytes/s)
     */
    CONNECTION_BANDWIDTH_SENT_LAST_MINUTE_TOTAL(false),

    /**
     * Average bandwidth used for incoming data in the last minute (Bytes/s)
     */
    CONNECTION_BANDWIDTH_RECEIVED_LAST_MINUTE_TOTAL(false),

    /**
     * The IPv4 address of the client
     */
    CONNECTION_CLIENT_IP(false),

    /**
     * Indicates whether the client is a channel commander or not
     */
    CLIENT_IS_CHANNEL_COMMANDER(true),

    /**
     * CRC32 checksum of the client icon
     */
    CLIENT_ICON_ID(true),

    /**
     * The country identifier of the client (i.e. DE)
     */
    CLIENT_COUNTRY(false);

    public static final Set<Property> CLIENT_EDIT = new HashSet<Property>();
    public static final Set<Property> CLIENT_READ = new HashSet<Property>();

    static
    {
        for (ClientProperty property : values())
        {
            if (property.editable)
            {
                CLIENT_EDIT.add(property);
            }
            CLIENT_READ.add(property);
        }
    }

    private boolean editable;

    ClientProperty(boolean editable)
    {
        this.editable = editable;
    }

    public String getName()
    {
        return this.name().toLowerCase();
    }

    public boolean accepts(Object value)
    {
        return true; // TODO
    }
}

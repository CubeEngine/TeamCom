package de.cubeisland.teamcom.query.property;

import de.cubeisland.teamcom.query.Property;

import java.util.HashSet;
import java.util.Set;

public enum VirtualServerProperty implements Property
{
    /**
     * Name of the virtual server
     */
    VIRTUALSERVER_NAME(true),
    /**
     * Welcome message of the virtual server
     */
    VIRTUALSERVER_WELCOMEMESSAGE(true),

    /**
     * Number of slots available on the virtual server
     */
    VIRTUALSERVER_MAXCLIENTS(true),
    /**
     * Password of the virtual server
     */
    VIRTUALSERVER_PASSWORD(true),
    /**
     * Indicates whether the server has a password set or not
     */
    VIRTUALSERVER_FLAG_PASSWORD(false),
    /**
     * Number of clients connected to the virtual server
     */
    VIRTUALSERVER_CLIENTSONLINE(false),
    /**
     * Number of ServerQuery clients connected to the virtual server
     */
    VIRTUALSERVER_QUERYCLIENTSONLINE(false),
    /**
     * Number of channels created on the virtual server
     */
    VIRTUALSERVER_CHANNELSONLINE(false),
    /**
     * Creation date and time of the virtual server as UTC timestamp
     */
    VIRTUALSERVER_CREATED(false),
    /**
     * Uptime in seconds
     */
    VIRTUALSERVER_UPTIME(false),
    /**
     * Host message of the virtual server
     */
    VIRTUALSERVER_HOSTMESSAGE(true),
    /**
     * Host messagemode of the virtual server ( see Definitions )
     */
    VIRTUALSERVER_HOSTMESSAGE_MODE(true),
    /**
     * Default server group ID
     */
    VIRTUALSERVER_DEFAULT_SERVER_GROUP(true),
    /**
     * Default channel group ID
     */
    VIRTUALSERVER_DEFAULT_CHANNEL_GROUP(true),
    /**
     * Default channel administrator group ID
     */
    VIRTUALSERVER_DEFAULT_CHANNEL_ADMIN_GROUP(true),
    /**
     * Operating system the server is running on
     */
    VIRTUALSERVER_PLATFORM(false),
    /**
     * Server version information including build number
     */
    VIRTUALSERVER_VERSION(false),
    /**
     * Max bandwidth for outgoing file transfers on the virtual server (Bytes/s)
     */
    VIRTUALSERVER_MAX_DOWNLOAD_TOTAL_BANDWIDTH(true),
    /**
     * Max bandwidth for incoming file transfers on the virtual server (Bytes/s)
     */
    VIRTUALSERVER_MAX_UPLOAD_TOTAL_BANDWIDTH(true),
    /**
     * Host banner URL opened on click
     */
    VIRTUALSERVER_HOSTBANNER_URL(true),
    /**
     * Host banner URL used as image source
     */
    VIRTUALSERVER_HOSTBANNER_GFX_URL(true),
    /**
     * Interval for reloading the banner on client - side
     */
    VIRTUALSERVER_HOSTBANNER_GFX_INTERVAL(true),
    /**
     * Number of complaints needed to ban a client automatically
     */
    VIRTUALSERVER_COMPLAIN_AUTOBAN_COUNT(true),
    /**
     * Time in seconds used for automatic bans triggered by complaints
     */
    VIRTUALSERVER_COMPLAIN_AUTOBAN_TIME(true),
    /**
     * Time in seconds before a complaint is deleted automatically
     */
    VIRTUALSERVER_COMPLAIN_REMOVE_TIME(true),
    /**
     * Number of clients in the same channel needed to force silence
     */
    VIRTUALSERVER_MIN_CLIENTS_IN_CHANNEL_BEFORE_FORCED_SILENCE(true),
    /**
     * Client volume lowered automatically while a priority speaker is talking
     */
    VIRTUALSERVER_PRIORITY_SPEAKER_DIMM_MODIFICATOR(true),
    /**
     * Anti - flood points removed from a client for being good
     */
    VIRTUALSERVER_ANTIFLOOD_POINTS_TICK_REDUCE(true),
    /**
     * Anti - flood points needed to block commands being executed by the client
     */
    VIRTUALSERVER_ANTIFLOOD_POINTS_NEEDED_COMMAND_BLOCK(true),

    /**
     * Anti - flood points needed to block incoming connections from the client
     */
    VIRTUALSERVER_ANTIFLOOD_POINTS_NEEDED_IP_BLOCK(true),
    /**
     * The display mode for the virtual servers hostbanner (see Definitions)
     */
    VIRTUALSERVER_HOSTBANNER_MODE(true),
    /**
     * Indicates whether the initial privilege key for the virtual server has been used or not
     */
    VIRTUALSERVER_ASK_FOR_PRIVILEGEKEY(false),
    /**
     * Total number of clients connected to the virtual server since it was last started
     */
    VIRTUALSERVER_CLIENT_CONNECTIONS(false),
    /**
     * Total number of ServerQuery clients connected to the virtual server since it was last started
     */
    VIRTUALSERVER_QUERY_CLIENT_CONNECTIONS(false),
    /**
     * Text used for the tooltip of the host button on client - side
     */
    VIRTUALSERVER_HOSTBUTTON_TOOLTIP(true),
    /**
     * Text used for the tooltip of the host button on client - side
     */
    VIRTUALSERVER_HOSTBUTTON_GFX_URL(true),
    /**
     * URL opened on click on the host button
     */
    VIRTUALSERVER_HOSTBUTTON_URL(true),
    /**
     * Download quota for the virtual server (MByte)
     */
    VIRTUALSERVER_DOWNLOAD_QUOTA(true),
    /**
     * Download quota for the virtual server (MByte)
     */
    VIRTUALSERVER_UPLOAD_QUOTA(true),
    /**
     * Number of bytes downloaded from the virtual server on the current month
     */
    VIRTUALSERVER_MONTH_BYTES_DOWNLOADED(false),
    /**
     * Number of bytes uploaded to the virtual server on the current month
     */
    VIRTUALSERVER_MONTH_BYTES_UPLOADED(false),
    /**
     * Number of bytes downloaded from the virtual server since it was last started
     */
    VIRTUALSERVER_TOTAL_BYTES_DOWNLOADED(false),
    /**
     * Number of bytes uploaded to the virtual server since it was last started
     */
    VIRTUALSERVER_TOTAL_BYTES_UPLOADED(false),
    /**
     * Unique ID of the virtual server
     */
    VIRTUALSERVER_UNIQUE_IDENTIFER(false),
    /**
     * Database ID of the virtual server
     */
    VIRTUALSERVER_ID(false),
    /**
     * Machine ID identifying the server instance associated with the virtual server in the database
     */
    VIRTUALSERVER_MACHINE_ID(true),
    /**
     * UDP port the virtual server is listening on
     */
    VIRTUALSERVER_PORT(true),
    /**
     * Indicates whether the server starts automatically with the server instance or not
     */
    VIRTUALSERVER_AUTOSTART(true),
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
     * Status of the virtual server (online | virtual online | offline | booting up | shutting down | ... )
     */
    VIRTUALSERVER_STATUS(true),
    /**
     * Indicates whether the server logs events related to clients or not
     */
    VIRTUALSERVER_LOG_CLIENT(true),
    /**
     * Indicates whether the server logs events related to ServerQuery clients or not
     */
    VIRTUALSERVER_LOG_QUERY(true),
    /**
     * Indicates whether the server logs events related to channels or not
     */
    VIRTUALSERVER_LOG_CHANNEL(true),
    /**
     * Indicates whether the server logs events related to permissions or not
     */
    VIRTUALSERVER_LOG_PERMISSIONS(true),
    /**
     * Indicates whether the server logs events related to server changes or not
     */
    VIRTUALSERVER_LOG_SERVER(true),
    /**
     * Indicates whether the server logs events related to file transfers or not
     */
    VIRTUALSERVER_LOG_FILETRANSFER(true),
    /**
     * Min client version required to connect
     */
    VIRTUALSERVER_MIN_CLIENT_VERSION(true),
    /**
     * Minimum client identity security level required to connect to the virtual server
     */
    VIRTUALSERVER_NEEDED_IDENTITY_SECURITY_LEVEL(true),
    /**
     * Phonetic name of the virtual server
     */
    VIRTUALSERVER_NAME_PHONETIC(true),
    /**
     * CRC32 checksum of the virtual server icon
     */
    VIRTUALSERVER_ICON_ID(true),
    /**
     * Number of reserved slots available on the virtual server
     */
    VIRTUALSERVER_RESERVED_SLOTS(true),
    /**
     * The average packet loss for speech data on the virtual server
     */
    VIRTUALSERVER_TOTAL_PACKETLOSS_SPEECH(false),
    /**
     * The average packet loss for keepalive data on the virtual server
     */
    VIRTUALSERVER_TOTAL_PACKETLOSS_KEEPALIVE(false),
    /**
     * The average packet loss for control data on the virtual server
     */
    VIRTUALSERVER_TOTAL_PACKETLOSS_CONTROL(false),
    /**
     * The average packet loss for all data on the virtual server
     */
    VIRTUALSERVER_TOTAL_PACKETLOSS_TOTAL(false),
    /**
     * The average ping of all clients connected to the virtual server
     */
    VIRTUALSERVER_TOTAL_PING(false),
    /**
     * The IPv4 address the virtual server is listening on
     */
    VIRTUALSERVER_IP(false),
    /**
     * Indicates whether the server appears in the global web server list or not
     */
    VIRTUALSERVER_WEBLIST_ENABLED(true),
    /**
     * The global codec encryption mode of the virtual server
     */
    VIRTUALSERVER_CODEC_ENCRYPTION_MODE(true),
    /**
     * The directory where the virtual servers filebase is located
     */
    VIRTUALSERVER_FILEBASE(false);

    public static final Set<Property> VIRTSERVER_EDIT = new HashSet<Property>();
    public static final Set<Property> VIRTSERVER_READ = new HashSet<Property>();

    static
    {
        for (VirtualServerProperty property : values())
        {
            if (property.editable)
            {
                VIRTSERVER_EDIT.add(property);
            }
            VIRTSERVER_READ.add(property);
        }
    }

    private boolean editable;

    VirtualServerProperty(boolean editable)
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

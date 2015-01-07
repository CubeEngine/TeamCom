package de.cubeisland.teamcom.query.property;

import de.cubeisland.teamcom.query.Property;

import java.util.HashSet;
import java.util.Set;

public enum ServerInstanceProperty implements Property
{
    /**
     * Uptime in seconds
     */
    INSTANCE_UPTIME(false),

    /**
     * Current server date and time as UTC timestamp
     */
    HOST_TIMESTAMP_UTC(false),

    /**
     * Number of virtual servers running
     */
    VIRTUALSERVERS_RUNNING_TOTAL(false),

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
     * Database revision number
     */
    SERVERINSTANCE_DATABASE_VERSION(false),

    /**
     * Default ServerQuery group ID
     */
    SERVERINSTANCE_GUEST_SERVERQUERY_GROUP(true),

    /**
     * Default template group ID for administrators on new virtual servers (used to create initial token)
     */
    SERVERINSTANCE_TEMPLATE_SERVERADMIN_GROUP(true),

    /**
     * TCP port used for file transfers
     */
    SERVERINSTANCE_FILETRANSFER_PORT(true),

    /**
     * Max bandwidth available for outgoing file transfers (Bytes/s)
     */
    SERVERINSTANCE_MAX_DOWNLOAD_TOTAL_BANDWITDH(true),

    /**
     * Max bandwidth available for incoming file transfers (Bytes/s)
     */
    SERVERINSTANCE_MAX_UPLOAD_TOTAL_BANDWITDH(true),

    /**
     * Default server group ID used in templates
     */
    SERVERINSTANCE_TEMPLATE_SERVERDEFAULT_GROUP(true),

    /**
     * Default channel group ID used in templates
     */
    SERVERINSTANCE_TEMPLATE_CHANNELDEFAULT_GROUP(true),

    /**
     * Default channel administrator group ID used in templates
     */
    SERVERINSTANCE_TEMPLATE_CHANNELADMIN_GROUP(true),

    /**
     * Max number of clients for all virtual servers
     */
    VIRTUALSERVERS_TOTAL_MAXCLIENTS(false),

    /**
     * Number of clients online on all virtual servers
     */
    VIRTUALSERVERS_TOTAL_CLIENTS_ONLINE(false),

    /**
     * Number of channels on all virtual servers
     */
    VIRTUALSERVERS_TOTAL_CHANNELS_ONLINE(false),

    /**
     * Max number of commands allowed in <SERVERINSTANCE_SERVERQUERY_FLOOD_TIME> seconds
     */
    SERVERINSTANCE_SERVERQUERY_FLOOD_COMMANDS(true),

    /**
     * Timeframe in seconds for < SERVERINSTANCE_SERVERQUERY_FLOOD_COMMANDS> commands
     */
    SERVERINSTANCE_SERVERQUERY_FLOOD_TIME(true),

    /**
     * Time in seconds used for automatic bans triggered by the ServerQuery flood protection
     */
    SERVERINSTANCE_SERVERQUERY_FLOOD_BAN_TIME(true);

    public static final Set<Property> SERVERINST_EDIT = new HashSet<Property>();
    public static final Set<Property> SERVERINST_READ = new HashSet<Property>();

    static
    {
        for (ServerInstanceProperty property : values())
        {
            if (property.editable)
            {
                SERVERINST_EDIT.add(property);
            }
            SERVERINST_READ.add(property);
        }
    }

    private boolean editable;

    ServerInstanceProperty(boolean editable)
    {
        this.editable = editable;
    }

    public boolean accepts(Object value)
    {
        return true; // TODO
    }

    public String getName()
    {
        return this.name().toLowerCase();
    }
}

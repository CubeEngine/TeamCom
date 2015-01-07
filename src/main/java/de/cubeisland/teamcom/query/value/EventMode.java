package de.cubeisland.teamcom.query.value;

import de.cubeisland.teamcom.query.Value;

public enum EventMode implements Value
{
    /**
     * ServerMessages
     */
    TEXTSERVER,
    /**
     * ChannelMessages
     */
    TEXTCHANNEL,
    /**
     * PrivateMessages
     */
    TEXTPRIVATE,
    /**
     * Server Join & Left
     */
    SERVER,
    /**
     * Channel Join & Left
     * This mode needs a channel ID.
     */
    CHANNEL;

    public String stringify()
    {
        return name().toLowerCase();
    }
}

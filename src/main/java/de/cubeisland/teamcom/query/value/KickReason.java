package de.cubeisland.teamcom.query.value;

import de.cubeisland.teamcom.query.Value;

public enum KickReason implements Value
{
    /**
     * kick client from channel
     */
    CHANNEL(4),
    /**
     * kick client from server
     */
    SERVER(5);

    private int value;

    KickReason(int value)
    {
        this.value = value;
    }

    public String stringify()
    {
        return String.valueOf(value);
    }

}

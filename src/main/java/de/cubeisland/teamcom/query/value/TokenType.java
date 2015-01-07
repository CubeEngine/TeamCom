package de.cubeisland.teamcom.query.value;

import de.cubeisland.teamcom.query.Value;

public enum TokenType implements Value
{
    SERVER_GROUP(0),
    CHANNEL_GROUP(1);

    private int value;

    TokenType(int value)
    {
        this.value = value;
    }

    public String stringify()
    {
        return String.valueOf(value);
    }
}

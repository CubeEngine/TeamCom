package de.cubeisland.teamcom.query.value;

import de.cubeisland.teamcom.query.Value;

public enum TargetMode implements Value
{
    CLIENT(1),
    CHANNEL(2),
    VIRTUALSERVER(3);

    private int value;

    TargetMode(int value)
    {
        this.value = value;
    }

    public String stringify()
    {
        return String.valueOf(value);
    }
}

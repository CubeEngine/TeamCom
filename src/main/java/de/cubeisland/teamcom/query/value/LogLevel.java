package de.cubeisland.teamcom.query.value;

import de.cubeisland.teamcom.query.Value;

public enum LogLevel implements Value
{
    /**
     * everything that is really bad
     */
    ERROR(1),
    /**
     * everything that might be bad
     */
    WARNING(2),
    /**
     * output that might help find a problem
     */
    DEBUG(3),
    /**
     * informational output
     */
    INFO(4);

    private final int value;

    LogLevel(int value)
    {
        this.value = value;
    }

    public String stringify()
    {
        return String.valueOf(value);
    }
}

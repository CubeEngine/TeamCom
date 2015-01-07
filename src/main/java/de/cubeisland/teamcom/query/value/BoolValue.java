package de.cubeisland.teamcom.query.value;

import de.cubeisland.teamcom.query.Value;

public enum BoolValue implements Value
{
    TRUE(1),
    FALSE(0);

    private final int value;

    BoolValue(int value) {
        this.value = value;
    }

    public String stringify() {
        return String.valueOf(value);
    }
}

package de.cubeisland.teamcom.query.value;

import de.cubeisland.teamcom.query.Value;

public enum PermissionGroupDatabaseType implements Value
{
    /**
     * template group (used for new virtual servers)
     */
    TEMPLATE(0),
    /**
     * regular group (used for regular clients)
     */
    REGULAR(1),
    /**
     * global query group (used for ServerQuery clients)
     */
    QUERY(2);

    private int value;

    PermissionGroupDatabaseType(int value)
    {
        this.value = value;
    }

    public String stringify()
    {
        return String.valueOf(value);
    }
}

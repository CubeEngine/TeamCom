package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;
import de.cubeisland.teamcom.query.value.PermissionGroupDatabaseType;

/**
 * Creates a new server group using the name specified with name and displays its ID.
 * <br>The optional type parameter can be used to create ServerQuery groups and template groups.
 * <br>For detailed information, see Definitions.
 * <br><br>
 * Syntax:
 * <br>servergroupadd name={groupName} [type={groupDbType}]
 */
public class ServerGroupAdd extends Command
{
    public ServerGroupAdd name(String name)
    {
        this.setParam("name", name);
        return this;
    }

    public ServerGroupAdd type(PermissionGroupDatabaseType type)
    {
        this.setParam("type", type.stringify());
        return this;
    }
    //Permissions:"b_virtualserver_servergroup_create"
}

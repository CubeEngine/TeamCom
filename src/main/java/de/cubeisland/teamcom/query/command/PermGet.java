package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Displays the current value of the permission specified with permid or permsid for your own connection.
 * <br>This can be useful when you need to check your own privileges.
 * <br><br>
 * Syntax:
 * <br>permget permid={permID}
 * <br>permget permsid={permName}
 */
public class PermGet extends Command
{
    public PermGet by(String name)
    {
        this.setParam("permsid", name);
        return this;
    }

    public PermGet by(int id)
    {
        this.setParam("permid", id);
        return this;
    }
    //Permissions:"b_client_permissionoverview_own"
}

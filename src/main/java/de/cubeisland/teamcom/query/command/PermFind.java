package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Displays detailed information about all assignments of the permission specified with permid.
 * <br>The output is similar to permoverview which includes the type and the ID of the client, channel or group associated with the permission. A permission can be specified by permid or permsid.
 * <br><br>
 * Syntax:
 * <br>permfind [permid={permID}…] [permsid={permName}…]
 */
public class PermFind extends Command
{
    public PermFind by(String... name)
    {
        this.setParam("permsid", name);
        return this;
    }

    public PermFind by(int... id)
    {
        this.setParam("permid", id);
        return this;
    }
    //Permissions:"b_virtualserver_permission_find b_serverinstance_permission_find"
}

package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Removes a set of specified permissions from a client.
 * <br>Multiple permissions can be removed at once. A permission can be specified by permid or permsid.
 * <br><br>
 * Syntax:
 * <br>channeldelperm cldbid={clientDBID} [permid={permID}…] [permsid={permName}…]
 */
public class ClientDelPerm extends Command
{
    public ClientDelPerm delete(int clientDBId, int... permissionId)
    {
        this.setParam("cldbid", clientDBId);
        this.setParam("permid", permissionId);
        return this;
    }

    public ClientDelPerm delete(int clientDBId, String... permissionName)
    {
        this.setParam("cldbid", clientDBId);
        this.setParam("permsid", permissionName);
        return this;
    }
    //Permissions:"i_group_modify_power i_group_needed_modify_power i_permission_modify_power"
}

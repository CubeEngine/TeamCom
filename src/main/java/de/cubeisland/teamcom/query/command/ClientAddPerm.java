package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Adds a set of specified permissions to a client.
 * <br>Multiple permissions can be added by providing the three parameters of each permission.
 * <br>A permission can be specified by permid or permsid.
 * <br><br>
 * Syntax:
 * <br>clientaddperm cldbid={clientDBID} [permid={permID}…] [permsid={permName}…] permvalue={permValue}… permskip={1|0}…
 */
public class ClientAddPerm extends Command
{
    public ClientAddPerm add(int clientDBId, int permissionId, int value, boolean skip)
    {
        this.setParam("cldbid", clientDBId);
        this.setParam("permid", permissionId);
        this.setParam("permvalue", value);
        this.setParam("permskip", skip);
        return this;
    }

    public ClientAddPerm add(int clientDBId, String permissionName, int value, boolean skip)
    {
        this.setParam("cldbid", clientDBId);
        this.setParam("permsid", permissionName);
        this.setParam("permvalue", value);
        this.setParam("permskip", skip);
        return this;
    }
    //Permissions:"i_group_modify_power i_group_needed_modify_power i_permission_modify_power"
}

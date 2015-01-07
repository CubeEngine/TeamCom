package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Adds a set of specified permissions to the server group specified with sgid.
 * <br>Multiple permissions can be added by providing the four parameters of each permission.
 * <br>A permission can be specified by permid or permsid
 * <br><br>
 * Syntax:
 * <br>servergroupaddperm sgid={groupID} [permid={permID}…] [permsid={permName}…] permvalue={permValue}… permnegated={1|0}… permskip={1|0}…
 */
public class ServerGroupAddPerm extends Command
{
    public ServerGroupAddPerm addById(int serverGroupId, int permissionId, String value, boolean negate, boolean skip)
    {
        this.setParam("sgid", serverGroupId);
        this.setParam("permid", permissionId);
        this.setParam("permvalue", value);
        this.setParam("permnegated", negate);
        this.setParam("permskip", skip);
        return this;
    }

    public ServerGroupAddPerm addByName(int serverGroupId, String permissionName, String value, boolean negate,
                                        boolean skip)
    {
        this.setParam("sgid", serverGroupId);
        this.setParam("permsid", permissionName);
        this.setParam("permvalue", value);
        this.setParam("permnegated", negate);
        this.setParam("permskip", skip);
        return this;
    }
    //Permissions:"i_group_modify_power i_group_needed_modify_power i_permission_modify_power"
}

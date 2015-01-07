package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Removes a set of specified permissions from the server group specified with sgid.
 * <br>Multiple permissions can be removed at once. A permission can be specified by permid or permsid.
 * <br><br>
 * Syntax:
 * <br>servergroupdelperm sgid={groupID} [permid={permID}…] [permsid={permName}…]
 */
public class ServerGroupDelPerm extends Command
{
    public ServerGroupDelPerm removeById(int serverGroupId, int... permissionId)
    {
        this.setParam("sgid", serverGroupId);
        this.setParam("permid", permissionId);
        return this;
    }

    public ServerGroupDelPerm removeByName(int sgid, String... permissionName)
    {
        this.setParam("sgid", sgid);
        this.setParam("permsid", permissionName);
        return this;
    }
    //Permissions:"i_group_modify_power i_group_needed_modify_power i_permission_modify_power"
}

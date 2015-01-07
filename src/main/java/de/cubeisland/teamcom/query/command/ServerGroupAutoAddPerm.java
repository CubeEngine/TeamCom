package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Adds a set of specified permissions to *ALL* regular server groups on all virtual servers.
 * <br>The target groups will be identified by the value of their i_group_auto_update_type permission specified with sgtype.
 * <br>Multiple permissions can be added at once. A permission can be specified by permid or permsid.
 * <br>The known values for sgtype are:
 * <br>10: Channel Guest
 * <br>15: Server Guest
 * <br>20: Query Guest
 * <br>25: Channel Voice
 * <br>30: Server Normal
 * <br>35: Channel Operator
 * <br>40: Channel Admin
 * <br>45: Server Admin
 * <br>50: Query Admin
 * <br><br>
 * Syntax:
 * <br>servergroupautoaddperm sgtype={groupID} [permid={permID}…] [permsid={permName}…] permvalue={permValue}… permnegated={1|0}… permskip={1|0}…
 */
public class ServerGroupAutoAddPerm extends Command
{
    public ServerGroupAutoAddPerm addById(int serverGroupType, int permissionId, int value, boolean negate,
                                          boolean skip)
    {
        this.setParam("sgtype", serverGroupType);
        this.setParam("permid", permissionId);
        this.setParam("permvalue", value);
        this.setParam("permnegated", negate);
        this.setParam("permskip", skip);
        return this;
    }

    public ServerGroupAutoAddPerm addByName(int serverGroupType, String permissionName, int value, boolean negate,
                                            boolean skip)
    {
        this.setParam("sgtype", serverGroupType);
        this.setParam("permsid", permissionName);
        this.setParam("permvalue", value);
        this.setParam("permnegated", negate);
        this.setParam("permskip", skip);
        return this;
    }
    //Permissions:"b_permission_modify_power_ignore"
}

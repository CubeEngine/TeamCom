package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;
import de.cubeisland.teamcom.query.value.PermissionGroupDatabaseType;

/**
 * Creates a copy of the server group specified with ssgid.
 * <br>If tsgid is set to 0, the server will create a new group.
 * <br>To overwrite an existing group, simply set tsgid to the ID of a designated target group.
 * <br>If a target group is set, the name parameter will be ignored.
 * <br>The type parameter can be used to create ServerQuery groups and template groups.
 * <br>For detailed information, see Definitions.
 * <br><br>
 * Syntax:
 * <br>servergroupcopy ssgid={sourceGroupID} tsgid={targetGroupID} name={groupName} type={groupDbType}
 */
public class ServerGroupCopy extends Command
{
    private ServerGroupCopy copy(int sourceServerGroupId, int targetGroupID, String groupName,
                                 PermissionGroupDatabaseType type)
    {
        this.setParam("ssgid", sourceServerGroupId);
        this.setParam("tsgid", targetGroupID);
        this.setParam("name", groupName);
        this.setParam("type", type.stringify());
        return this;
    }

    public ServerGroupCopy copyNew(int sourceServerGroupId, String groupName, PermissionGroupDatabaseType type)
    {
        return this.copy(sourceServerGroupId, 0, groupName, type);
    }

    public ServerGroupCopy copyEdit(int sourceServerGroupId, int targetGroupID, PermissionGroupDatabaseType type)
    {
        return this.copy(sourceServerGroupId, targetGroupID, null, type);
    }
    //Permissions:"b_virtualserver_servergroup_create i_group_modify_power i_group_needed_modify_power"
}

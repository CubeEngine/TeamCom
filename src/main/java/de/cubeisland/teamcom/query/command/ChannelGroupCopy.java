package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;
import de.cubeisland.teamcom.query.value.PermissionGroupDatabaseType;

/**
 * Creates a copy of the channel group specified with scgid.
 * <br>If tcgid is set to 0, the server will create a new group.
 * <br>To overwrite an existing group, simply set tcgid to the ID of a designated target group.
 * <br>If a target group is set, the name parameter will be ignored.
 * <br>The type parameter can be used to create ServerQuery groups and template groups.
 * <br>For detailed information, see Definitions.
 * <br><br>
 * Syntax:
 * <br>channelgroupcopy scgid={sourceGroupID} tcgid={targetGroupID} name={groupName} type={groupDbType}
 */
public class ChannelGroupCopy extends Command
{
    public ChannelGroupCopy copyEdit(int sourceId, int targetId, PermissionGroupDatabaseType type)
    {
        return this.copy(sourceId, targetId, null, type);
    }

    public ChannelGroupCopy copyNew(int sourceId, String name, PermissionGroupDatabaseType type)
    {
        return this.copy(sourceId, 0, name, type);
    }

    private ChannelGroupCopy copy(int sourceId, int targetId, String name, PermissionGroupDatabaseType type)
    {
        this.setParam("scgid", sourceId);
        this.setParam("tcgid", targetId);
        this.setParam("name", name);
        this.setParam("type", type);
        return this;
    }
    //Permissions:"b_virtualserver_channelgroup_create i_group_modify_power i_group_needed_modify_power"
}

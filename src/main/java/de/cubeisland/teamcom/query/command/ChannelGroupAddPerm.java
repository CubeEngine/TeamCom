package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Adds a set of specified permissions to a channel group.
 * <br>Multiple permissions can be added by providing the two parameters of each permission.
 * <br>A permission can be specified by permid or permsid.
 * <br><br>
 * Syntax:
 * <br>channelgroupaddperm cgid={groupID} [permid={permID}…] [permsid={permName}…] permvalue={permValue}…
 */
public class ChannelGroupAddPerm extends Command
{
    public ChannelGroupAddPerm addById(int channelGroupId, int permissionId, int value)
    {
        this.setParam("cgid", channelGroupId);
        this.setParam("permid", permissionId);
        this.setParam("permvalue", value);
        return this;
    }

    public ChannelGroupAddPerm addByName(int channelGroupId, String permissionName, int value)
    {
        this.setParam("cgid", channelGroupId);
        this.setParam("permsid", permissionName);
        this.setParam("permvalue", value);
        return this;
    }
    //Permissions:"i_group_modify_power i_group_needed_modify_power i_permission_modify_power"
}

package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Adds a set of specified permissions to a channel.
 * <br>Multiple permissions can be added by providing the two parameters of each permission.
 * <br>A permission can be specified by permid or permsid.
 * <br><br>
 * Syntax:
 * <br>channeladdperm cid={channelID} [permid={permID}…] [permsid={permName}…] permvalue={permValue}…
 */
public class ChannelAddPerm extends Command
{
    public ChannelAddPerm addById(int channelId, int permissionId, int value)
    {
        this.setParam("cid", channelId);
        this.setParam("permid", permissionId);
        this.setParam("permvalue", value);
        return this;
    }

    public ChannelAddPerm addByName(int channelId, String permissionName, int value)
    {
        this.setParam("cid", channelId);
        this.setParam("permsid", permissionName);
        this.setParam("permvalue", value);
        return this;
    }
    //Permissions:"i_group_modify_power i_group_needed_modify_power i_permission_modify_power"
}

package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Removes a set of specified permissions from a channel.
 * <br>Multiple permissions can be removed at once.
 * <br>A permission can be specified by permid or permsid.
 * <br><br>
 * Syntax:
 * <br>channeldelperm cid={id} [permid={permID}..] [permsid={permName}…]
 */
public class ChannelDelPerm extends Command
{
    public ChannelDelPerm deleteById(int channelId, int... permissionId)
    {
        this.setParam("cid", channelId);
        this.setParam("permid", permissionId);
        return this;
    }

    public ChannelDelPerm deleteByName(int channelId, String... permissionName)
    {
        this.setParam("cid", channelId);
        this.setParam("permsid", permissionName);
        return this;
    }
    //Permissions:"i_group_modify_power i_group_needed_modify_power i_permission_modify_power"
}

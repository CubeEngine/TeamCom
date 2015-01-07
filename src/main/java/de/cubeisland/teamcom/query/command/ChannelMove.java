package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Moves a channel to a new parent channel with the ID cpid.
 * <br>If order is specified, the channel will be sorted right under the channel with the specified ID.
 * <br>If order is set to 0, the channel will be sorted right below the new parent.
 * <br><br>
 * Syntax:
 * <br>channelmove cid={channelID} cpid={channelParentID} [order={channelSortOrder}]
 */
public class ChannelMove extends Command
{
    public ChannelMove channelId(int channelId, int channelParentId)
    {
        this.setParam("cid", channelId);
        this.setParam("cpid", channelParentId);
        return this;
    }

    public ChannelMove under(int channelId)
    {
        this.setParam("order", channelId);
        return this;
    }

    public ChannelMove underParent()
    {
        return this.under(0);
    }
    //Permissions:"i_channel_min_depth i_channel_max_depth b_channel_modify_parent b_channel_modify_sortorder"
}

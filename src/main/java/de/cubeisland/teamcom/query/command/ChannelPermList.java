package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Displays a list of permissions defined for a channel.
 * <br><br>
 * Syntax:
 * <br>channelpermlist cid={channelID} [-permsid]
 */
public class ChannelPermList extends Command
{

    public ChannelPermList getNameList(int channelId)
    {
        this.setFlag("permsid");
        return this.getList(channelId);
    }

    public ChannelPermList getList(int channelId)
    {
        this.setParam("cid", channelId);
        return this;
    }
    //Permissions:"b_virtualserver_channel_permission_list"
}

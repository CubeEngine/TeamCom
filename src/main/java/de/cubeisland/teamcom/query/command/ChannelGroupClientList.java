package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Displays all the client and/or channel IDs currently assigned to channel groups.
 * <br>All three parameters are optional so you're free to choose the most suitable combination for your requirements.
 * <br><br>
 * Syntax:
 * <br>channelgroupclientlist [cid={channelID}] [cldbid={clientDBID}] [cgid={groupID}]
 */
public class ChannelGroupClientList extends Command
{
    public ChannelGroupClientList byChannelId(int channelId)
    {
        this.setParam("cid", channelId);
        return this;
    }

    public ChannelGroupClientList byClientDBId(int clientDBId)
    {
        this.setParam("cldbid", clientDBId);
        return this;
    }

    public ChannelGroupClientList byChannelGroupId(int channelGroupId)
    {
        this.setParam("cgid", channelGroupId);
        return this;
    }
    //Permissions:"b_virtualserver_channelgroup_client_list"
}

package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Displays a list of permissions defined for a client in a specific channel.
 * <br><br>
 * Syntax:
 * <br>channelclientpermlist cid={channelID} cldbid={clientDBID} [-permsid]
 */
public class ChannelClientPermList extends Command
{
    public ChannelClientPermList nameList(int channelId, int clientDBId)
    {
        this.setFlag("permsid");
        return this.list(channelId, clientDBId);
    }

    public ChannelClientPermList list(int channelId, int clientDBId)
    {
        this.setParam("cid", channelId);
        this.setParam("cldbid", clientDBId);
        return this;
    }
    //Permissions:"b_virtualserver_channelclient_permission_list"
}

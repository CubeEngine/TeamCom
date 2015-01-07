package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Sets the channel group of a client to the ID specified with cgid.
 * <br><br>
 * Syntax:
 * <br>setclientchannelgroup cgid={groupID} cid={channelID} cldbid={clientDBID}
 */
public class SetClientChannelGroup extends Command
{
    public SetClientChannelGroup set(int channelGroupId, int channelId, int clientDBId)
    {
        this.setParam("cgid", channelGroupId);
        this.setParam("cid", channelId);
        this.setParam("cldbid", clientDBId);
        return this;
    }
    //Permissions:"i_group_member_add_power i_group_needed_member_add_power i_group_member_remove_power i_group_needed_member_remove_power"
}

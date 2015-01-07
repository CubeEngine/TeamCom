package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Displays detailed configuration information about a channel including ID, topic, description, etc.
 * <br>For detailed information, see Channel Properties.
 * <br><br>
 * Syntax:
 * <br>channelinfo cid={channelID}
 */
public class ChannelInfo extends Command
{
    public ChannelInfo byId(int channelId)
    {
        this.setParam("cid", channelId);
        return this;
    }
    //Permissions:"b_channel_info_view"
}

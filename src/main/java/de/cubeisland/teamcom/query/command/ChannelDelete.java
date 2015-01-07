package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;
import de.cubeisland.teamcom.query.TeamComException;
import de.cubeisland.teamcom.query.QueryConnection;

/**
 * Deletes an existing channel by ID.
 * <br>If force is set to 1, the channel will be deleted even if there are clients within.
 * <br>The clients will be kicked to the default channel with an appropriate reason message.
 * <br><br>
 * Syntax:
 * <br>channeldelete cid={channelID} force={1|0}
 */
public class ChannelDelete extends Command
{
    public ChannelDelete delete(int channelId, boolean force)
    {
        this.setParam("cid", channelId);
        this.setParam("force", force);
        return this;
    }
    //Permissions:"b_channel_delete_permanent b_channel_delete_semi_permanent b_channel_delete_temporary b_channel_delete_flag_force"

    @Override
    protected String execute(QueryConnection query) throws TeamComException
    {
        String response = super.execute(query);
        if (query.current().isInChannel(this.arguments.get("cid")))
        {
            query.updateCurrent();
        }
        return response;
    }
}

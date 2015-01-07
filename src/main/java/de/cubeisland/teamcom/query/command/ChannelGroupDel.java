package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Deletes a channel group by ID.
 * <br>If force is set to 1, the channel group will be deleted even if there are clients within.
 * <br><br>
 * Syntax:
 * <br>channelgroupdel cgid={groupID} force={1|0}
 */
public class ChannelGroupDel extends Command
{
    public ChannelGroupDel delete(int channelGroupId, boolean force)
    {
        this.setParam("cgid", channelGroupId);
        this.setParam("force", force);
        return this;
    }
    //Permissions:"b_virtualserver_channelgroup_delete"
}

package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Displays a list of permissions assigned to the channel group specified with cgid.
 * <br>If the –permsid option is specified, the output will contain the permission names instead of the internal IDs.
 * <br><br>
 * Syntax:
 * <br>channelgrouppermlist cgid={groupID} [-permsid]
 */
public class ChannelGroupPermList extends Command
{
    public ChannelGroupPermList listNames(int channelGroupId)
    {
        this.list(channelGroupId);
        this.setFlag("permsid");
        return this;
    }

    public ChannelGroupPermList list(int channelGroupId)
    {
        this.setParam("cgid", channelGroupId);
        return this;
    }
    //Permissions:"b_virtualserver_channelgroup_permission_list"
}

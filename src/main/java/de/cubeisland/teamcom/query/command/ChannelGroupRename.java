package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Changes the name of a specified channel group.
 * <br><br>
 * Syntax:
 * <br>channelgrouprename cgid={groupID} name={groupName}
 */
public class ChannelGroupRename extends Command
{
    public ChannelGroupRename rename(int channelGroupId, String newName)
    {
        this.setParam("cgid", channelGroupId);
        this.setParam("name", newName);
        return this;
    }
    //Permissions:"i_group_modify_power i_group_needed_modify_power"
}

package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Removes a set of specified permissions from the channel group.
 * <br>Multiple permissions can be removed at once.
 * <br>A permission can be specified by permid or permsid.
 * <br><br>
 * Syntax:
 * <br>channelgroupdelperm cgid={groupID} [permid={permID}…] [permsid={permName}…]
 */
public class ChannelGroupDelPerm extends Command
{
    public ChannelGroupDelPerm deleteById(int cgid, int... id)
    {
        this.setParam("cgid", cgid);
        this.setParam("permid", id);
        return this;
    }

    public ChannelGroupDelPerm deleteByName(int cgid, String... name)
    {
        this.setParam("cgid", cgid);
        this.setParam("permsid", name);
        return this;
    }
    //Permissions:"i_group_modify_power i_group_needed_modify_power i_permission_modify_power"
}

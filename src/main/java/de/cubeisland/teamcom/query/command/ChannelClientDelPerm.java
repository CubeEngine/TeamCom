package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Removes a set of specified permissions from a client in a specific channel.
 * <br>Multiple permissions can be removed at once.
 * <br>A permission can be specified by permid or permsid.
 * <br><br>
 * Syntax:
 * <br>channelclientdelperm cid={channelID} cldbid={clientDBID} [permid={permID}…] [permsid={permName}…]
 */
public class ChannelClientDelPerm extends Command
{
    public ChannelClientDelPerm delete(int channelId, int clientDBId, int... permissionId)
    {
        this.setParam("cid", channelId);
        this.setParam("cldbid", clientDBId);
        this.setParam("permid", permissionId);
        return this;
    }

    public ChannelClientDelPerm delete(int channelId, int clientDBId, String... permissionName)
    {
        this.setParam("cid", channelId);
        this.setParam("cldbid", clientDBId);
        this.setParam("permsid", permissionName);
        return this;
    }
    //Permissions:"i_group_modify_power i_group_needed_modify_power i_permission_modify_power"
}

package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Adds a set of specified permissions to a client in a specific channel.
 * <br>Multiple permissions can be added by providing the three parameters of each permission.
 * <br>A permission can be specified by permid or permsid.
 * <br><br>
 * Syntax:
 * <br>channelclientaddperm cid={channelID} cldbid={clientDBID} [permid={permID}…] [permsid={permName}…] permvalue={permValue}…
 */
public class ChannelClientAddPerm extends Command
{
    public ChannelClientAddPerm add(int channelId, int clientDBId, int permissionId, int value)
    {
        this.setParam("cid", channelId);
        this.setParam("cldbid", clientDBId);
        this.setParam("permid", permissionId);
        this.setParam("permvalue", value);
        return this;
    }

    public ChannelClientAddPerm add(int channelId, int clientDBId, String permissionName, int value)
    {
        this.setParam("cid", channelId);
        this.setParam("cldbid", clientDBId);
        this.setParam("permsid", permissionName);
        this.setParam("permvalue", value);
        return this;
    }
    //Permissions:"i_group_modify_power i_group_needed_modify_power i_permission_modify_power"
}

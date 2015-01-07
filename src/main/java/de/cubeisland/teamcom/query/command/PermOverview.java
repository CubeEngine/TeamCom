package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Displays all permissions assigned to a client for the channel specified with cid.
 * <br>If permid is set to 0, all permissions will be displayed.
 * <br>A permission can be specified by permid or permsid.
 * <br><br>
 * Syntax:
 * <br>permoverview cid={channelID} cldbid={clientDBID} [permid={permID}…] [permsid={permName}…]
 */
public class PermOverview extends Command
{
    public PermOverview overview(int channelId, int clientDBId, int... permissionId)
    {
        this.setParam("cid", channelId);
        this.setParam("cldbid", clientDBId);
        this.setParam("permid", permissionId);
        return this;
    }

    public PermOverview overview(int channelId, int clientDBId, String... permissionName)
    {
        this.setParam("cid", channelId);
        this.setParam("cldbid", clientDBId);
        this.setParam("permsid", permissionName);
        return this;
    }
    //Permissions:"b_client_permissionoverview_view"
}

package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Displays a list of permissions defined for a client.
 * <br><br>
 * Syntax:
 * <br>clientpermlist cldbid={clientDBID} [-permsid]
 */
public class ClientPermList extends Command
{
    public ClientPermList getNameList(int clientDBId)
    {
        this.setFlag("permsid");
        return this.getList(clientDBId);
    }

    public ClientPermList getList(int clientDBId)
    {
        this.setParam("cldbid", clientDBId);
        return this;
    }
    //Permissions:"b_virtualserver_client_permission_list"
}

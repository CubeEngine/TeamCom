package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Displays the IDs of all clients currently residing in the server group specified with sgid.
 * <br>If you're using the optional -names option, the output will also contain the last known nickname and the unique identifier of the clients.
 * <br><br>
 * Syntax:
 * <br>servergroupclientlist sgid={groupID} [-names]
 */
public class ServerGroupClientList extends Command
{
    public ServerGroupClientList getList(int serverGroupId)
    {
        this.setParam("sgid", serverGroupId);
        return this;
    }

    public ServerGroupClientList withLastNickname()
    {
        this.setFlag("names");
        return this;
    }
    //Permissions:"b_virtualserver_servergroup_client_list"
}

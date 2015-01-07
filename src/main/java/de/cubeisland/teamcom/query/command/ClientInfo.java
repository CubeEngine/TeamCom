package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Displays detailed configuration information about a client including unique ID, nickname, client version, etc.
 * <br><br>
 * Syntax:
 * <br>clientinfo clid={clientID}
 */
public class ClientInfo extends Command
{
    public ClientInfo by(int clientId)
    {
        this.setParam("clid", clientId);
        return this;
    }
    //Permissions:"b_client_info_view"
}

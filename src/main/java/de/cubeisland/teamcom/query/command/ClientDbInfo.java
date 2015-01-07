package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Displays detailed database information about a client including unique ID, creation date, etc.
 * <br><br>
 * Syntax:
 * <br>clientdbinfo cldbid={clientDBID}
 */
public class ClientDbInfo extends Command
{
    public ClientDbInfo by(int clientDBId)
    {
        this.setParam("cldbid", clientDBId);
        return this;
    }
    //Permissions:"b_virtualserver_client_dbinfo"
}

package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Deletes a clients properties from the database.
 * <br><br>
 * Syntax:
 * <br>clientdbdelete cldbid={clientDBID}
 */
public class ClientDbDelete extends Command
{
    public ClientDbDelete by(int clientDBId)
    {
        this.setParam("cldbid", clientDBId);
        return this;
    }
    //Permissions:"b_client_delete_dbproperties"
}

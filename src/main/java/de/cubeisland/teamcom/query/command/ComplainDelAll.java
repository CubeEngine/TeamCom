package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Deletes all complaints about the client with database ID tcldbid from the server.
 * <br><br>
 * Syntax:
 * <br>complaindelall tcldbid={targetClientDBID}
 */
public class ComplainDelAll extends Command
{
    public ComplainDelAll by(int targetClientDBId)
    {
        this.setParam("tcldbid", targetClientDBId);
        return this;
    }
    //Permissions:"b_client_complain_delete"
}

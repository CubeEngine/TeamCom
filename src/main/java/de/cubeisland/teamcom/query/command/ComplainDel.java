package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Deletes the complaint about the client with ID tcldbid submitted by the client with ID fcldbid from the server.
 * <br><br>
 * Syntax:
 * <br>complaindel tcldbid={targetClientDBID} fcldbid={fromClientDBID}
 */
public class ComplainDel extends Command
{
    public ComplainDel targetClientDBId(int targetClientDBId, int fromClientDBId)
    {
        this.setParam("tcldbid", targetClientDBId);
        this.setParam("fcldbid", fromClientDBId);
        return this;
    }
    //Permissions:"b_client_complain_delete b_client_complain_delete_own"
}

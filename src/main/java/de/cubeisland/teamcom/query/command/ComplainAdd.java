package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Submits a complaint about the client with database ID tcldbid to the server.
 * <br><br>
 * Syntax:
 * <br>complainadd tcldbid={targetClientDBID} message={text}
 */
public class ComplainAdd extends Command
{
    public ComplainAdd add(int targetClientDBId, String message)
    {
        this.setParam("tcldbid", targetClientDBId);
        this.setParam("message", message);
        return this;
    }
    //Permissions:"i_client_complain_poweri_client_needed_complain_power"
}

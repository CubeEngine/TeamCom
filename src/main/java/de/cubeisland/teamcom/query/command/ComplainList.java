package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Displays a list of complaints on the selected virtual server.
 * <br>If tcldbid is specified, only complaints about the targeted client will be shown.
 * <br><br>
 * Syntax:
 * <br>complainlist [tcldbid={targetClientDBID}]
 */
public class ComplainList extends Command
{
    public ComplainList by(int targetClientDBId)
    {
        this.setParam("tcldbid", targetClientDBId);
        return this;
    }
    //Permissions:"b_client_complain_list"
}

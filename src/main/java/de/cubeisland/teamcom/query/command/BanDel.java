package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Deletes the ban rule with ID banid from the server.
 * <br><br>
 * Syntax:
 * <br>bandel banid={banID}
 */
public class BanDel extends Command
{
    public BanDel by(int banId)
    {
        this.setParam("banid", banId);
        return this;
    }
    //Permissions:"b_client_ban_delete b_client_ban_delete_own"
}

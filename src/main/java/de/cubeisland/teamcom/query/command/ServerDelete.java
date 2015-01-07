package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Deletes the virtual server specified with sid.
 * <br>Please note that only virtual servers in stopped state can be deleted.
 * <br><br>
 * Syntax:
 * <br>serverdelete sid={serverID}
 */
public class ServerDelete extends Command
{
    public ServerDelete by(int serverId)
    {
        this.setParam("sid", serverId);
        return this;
    }
    //Permissions:"b_virtualserver_delete"
}

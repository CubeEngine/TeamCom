package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Starts the virtual server specified with sid.
 * <br>Depending on your permissions, you're able to start either your own virtual server only or all virtual servers in the server instance.
 * <br><br>
 * Syntax:
 * <br>serverstart sid={serverID}
 */
public class ServerStart extends Command
{
    public ServerStart by(int serverId)
    {
        this.setParam("sid", serverId);
        return this;
    }
    //Permissions:"b_virtualserver_start_any", "b_virtualserver_start"
}

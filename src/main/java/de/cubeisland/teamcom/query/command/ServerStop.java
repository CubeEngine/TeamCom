package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Stops the virtual server specified with sid.
 * <br>Depending on your permissions, you're able to stop either your own virtual server only or all virtual servers in the server instance.
 * <br><br>
 * Syntax:
 * <br>serverstop sid={serverID}
 */
public class ServerStop extends Command
{
    public ServerStop by(int serverId)
    {
        this.setParam("sid", serverId);
        return this;
    }
    //Permissions:"b_virtualserver_stop_any", "b_virtualserver_stop"
}

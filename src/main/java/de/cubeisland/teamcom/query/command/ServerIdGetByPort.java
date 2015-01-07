package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Displays the database ID of the virtual server running on the UDP port specified by virtualserver_port.
 * <br><br>
 * Syntax:
 * <br>serveridgetbyport virtualserver_port={serverPort}
 */
public class ServerIdGetByPort extends Command
{
    public ServerIdGetByPort port(int port)
    {
        this.setParam("virtualserver_port", port);
        return this;
    }
    //Permissions:"b_serverinstance_virtualserver_list"
}

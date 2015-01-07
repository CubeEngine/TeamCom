package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;
import de.cubeisland.teamcom.query.property.VirtualServerProperty;

/**
 * Creates a new virtual server using the given properties and displays its ID, port and initial administrator privilege key.
 * <br>If virtualserver_port is not specified, the server will test for the first unused UDP port.
 * <br>The first virtual server will be running on UDP port 9987 by default.
 * <br>Subsequently started virtual servers will be running on increasing UDP port numbers.
 * <br>For detailed information, see Virtual Server Properties.
 * <br><br>
 * Syntax:
 * <br>servercreate virtualserver_name={serverName} [virtualserver_properties…]
 */
public class ServerCreate extends Command
{
    public ServerCreate name(String name)
    {
        this.setParam("name", name);
        return this;
    }

    public ServerCreate property(VirtualServerProperty property, Object value)
    {
        this.setProperty(property, value);
        return this;
    }
    //Permissions:"b_virtualserver_create"
}

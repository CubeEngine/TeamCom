package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.property.ClientProperty;
import de.cubeisland.teamcom.query.Command;

/**
 * Changes a clients settings using given properties.
 * <br>For detailed information, see Client Properties.
 * <br><br>
 * Syntax:
 * <br>clientedit clid={clientID} [client_properties…]
 */
public class ClientEdit extends Command
{
    public ClientEdit by(int clientId)
    {
        this.setParam("clid", clientId);
        return this;
    }

    public ClientEdit property(ClientProperty property, Object value)
    {
        this.setProperty(property, value);
        return this;
    }
    //Permissions:"b_client_modify_description b_client_set_talk_power"
}

package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.property.ClientProperty;
import de.cubeisland.teamcom.query.Command;

/**
 * Change your ServerQuery clients settings using given properties.
 * <br>For detailed information, see Client Properties.
 * <br><br>
 * Syntax:
 * <br>clientupdate [client_properties…]
 */
public class ClientUpdate extends Command
{
    public ClientUpdate property(ClientProperty property, Object value)
    {
        this.setProperty(property, value);
        return this;
    }
}

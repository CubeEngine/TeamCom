package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.property.ClientProperty;
import de.cubeisland.teamcom.query.Command;

/**
 * Changes a clients settings using given properties.
 * <br>For detailed information, see Client Properties.
 * <br><br>
 * Syntax:
 * <br>clientdbedit cldbid={clientDBID} [client_properties…]
 */
public class ClientDbEdit extends Command
{
    public ClientDbEdit by(int clientDBId)
    {
        this.setParam("cldbid", clientDBId);
        return this;
    }

    public ClientDbEdit property(ClientProperty property, Object value)
    {
        this.setProperty(property, value);
        return this;
    }
    //Permissions:"b_client_modify_dbproperties b_client_modify_description b_client_set_talk_power"
}

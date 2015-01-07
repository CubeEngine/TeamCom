package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;
import de.cubeisland.teamcom.query.property.ServerInstanceProperty;

/**
 * Changes the server instance configuration using given properties.
 * <br>For detailed information, see Server Instance Properties.
 * <br><br>
 * Syntax:
 * <br>instanceedit [instance_properties…]
 */
public class InstanceEdit extends Command
{
    public InstanceEdit property(ServerInstanceProperty property, Object value)
    {
        this.setProperty(property, value);
        return this;
    }
    //Permissions:"b_serverinstance_modify_settings"
}

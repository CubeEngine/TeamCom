package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Displays the database ID of one or more permissions specified by permsid.
 * <br><br>
 * Syntax:
 * <br>permidgetbynameperms id={permName}…
 */
public class PermIdGetByName extends Command
{
    public PermIdGetByName by(String name)
    {
        this.setParam("id", name);
        return this;
    }
    //Permissions:"b_serverinstance_permission_list"
}

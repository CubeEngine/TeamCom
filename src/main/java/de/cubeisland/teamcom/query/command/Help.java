package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Provides information about ServerQuery commands.
 * <br>Used without parameters, help lists and briefly describes every command.
 * <br><br>
 * Syntax:
 * <br>help [{command}]
 */
public class Help extends Command
{
    public Help command(Command command)
    {
        this.addArg(command.getClass().getSimpleName().toLowerCase());
        return this;
    }
    //Permissions:"b_serverinstance_help_view"
}

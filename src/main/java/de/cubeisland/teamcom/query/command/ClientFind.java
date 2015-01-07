package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Displays a list of clients matching a given name pattern.
 * <br><br>
 * Syntax:
 * <br>clientfind pattern={clientName}
 */
public class ClientFind extends Command
{
    public ClientFind with(String pattern)
    {
        this.setParam("pattern", pattern);
        return this;
    }
    //Permissions:"b_virtualserver_client_search"
}

package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Displays a list of client database IDs matching a given pattern.
 * <br>You can either search for a clients last known nickname or his unique identity by using the -uid option.
 * <br><br>
 * Syntax:
 * <br>clientdbfind pattern={clientName|clientUID} [-uid]
 */
public class ClientDbFind extends Command
{
    public ClientDbFind byUid(String pattern)
    {
        this.setParam("pattern", pattern);
        this.setFlag("uid");
        return this;
    }

    public ClientDbFind byName(String pattern)
    {
        this.setParam("pattern", pattern);
        return this;
    }
    //Permissions:"b_virtualserver_client_dbsearch"
}

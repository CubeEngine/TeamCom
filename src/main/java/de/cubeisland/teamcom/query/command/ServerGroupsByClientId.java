package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Displays all server groups the client specified with cldbid is currently residing in.
 * <br><br>
 * Syntax:
 * <br>servergroupsbyclientid cldbid={clientDBID}
 */
public class ServerGroupsByClientId extends Command
{
    public ServerGroupsByClientId by(int clientDBId)
    {
        this.setParam("cldbid", clientDBId);
        return this;
    }
}

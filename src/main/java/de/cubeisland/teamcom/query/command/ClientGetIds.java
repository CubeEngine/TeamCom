package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Displays all client IDs matching the unique identifier specified by cluid.
 * <br><br>
 * Syntax:
 * <br>clientgetids cluid={clientUID}
 */
public class ClientGetIds extends Command
{
    public ClientGetIds by(String clientUId)
    {
        this.setParam("cluid", clientUId);
        return this;
    }
}

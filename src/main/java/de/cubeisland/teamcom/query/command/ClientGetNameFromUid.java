package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Displays the database ID and nickname matching the unique identifier specified by cluid.
 * <br><br>
 * Syntax:
 * <br>clientgetnamefromuid cluid={clientUID}
 */
public class ClientGetNameFromUid extends Command
{
    public ClientGetNameFromUid clientUId(String clientUId)
    {
        this.setParam("cluid", clientUId);
        return this;
    }
}

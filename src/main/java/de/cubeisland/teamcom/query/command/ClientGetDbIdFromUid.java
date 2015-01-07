package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Displays the database ID matching the unique identifier specified by cluid.
 * <br><br>
 * Syntax:
 * <br>clientgetdbidfromuid cluid={clientUID}
 */
public class ClientGetDbIdFromUid extends Command
{
    public ClientGetDbIdFromUid by(String clientUId)
    {
        this.setParam("cluid", clientUId);
        return this;
    }
}

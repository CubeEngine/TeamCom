package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Displays the unique identifier and nickname matching the database ID specified by cldbid.
 * <br><br>
 * Syntax:
 * <br>clientgetnamefromdbid cldbid={clientDBID}
 */
public class ClientGetNameFromDbId extends Command
{
    public ClientGetNameFromDbId by(int clientDBId)
    {
        this.setParam("cldbid", clientDBId);
        return this;
    }
}

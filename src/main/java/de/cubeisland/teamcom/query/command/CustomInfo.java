package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Displays a list of custom properties for the client specified with cldbid.
 * <br><br>
 * Syntax:
 * <br>custominfo cldbid={clientDBID}
 */
public class CustomInfo extends Command
{
    public CustomInfo by(String clientDBId)
    {
        this.setParam("cldbid", clientDBId);
        return this;
    }
}

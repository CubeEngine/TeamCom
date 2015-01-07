package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Bans the client specified with ID clid from the server.
 * <br>Please note that this will create two separate ban rules for the targeted clients IP address and his unique identifier.
 * <br><br>
 * Syntax:
 * <br>banclient clid={clientID} [time={timeInSeconds}] [banreason={text}]
 */
public class BanClient extends Command
{
    public BanClient ban(int clientId)
    {
        this.setParam("clid", clientId);
        return this;
    }

    public BanClient withReason(String reason)
    {
        this.setParam("banreason", reason);
        return this;
    }

    public BanClient temporary(int seconds)
    {
        this.setParam("time", seconds);
        return this;
    }
    //Permissions:"i_client_ban_power i_client_needed_ban_power"
}

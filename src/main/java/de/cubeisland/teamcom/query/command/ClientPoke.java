package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Sends a poke message to the client specified with clid.
 * <br><br>
 * Syntax:
 * <br>clientpoke clid={clientID}… msg={text}
 */
public class ClientPoke extends Command
{
    public ClientPoke poke(String msg, int... clientId)
    {
        this.setParam("clid", clientId);
        this.setParam("msg", msg);
        return this;
    }
    //Permissions:"i_client_poke_power i_client_needed_poke_power"
}

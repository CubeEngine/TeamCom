package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;
import de.cubeisland.teamcom.query.value.KickReason;

/**
 * Kicks one or more clients specified with clid from their currently joined channel or from the server, depending on reasonid.
 * <br>The reasonmsg parameter specifies a text message sent to the kicked clients.
 * <br>This parameter is optional and may only have a maximum of 40 characters.
 * <br>For detailed information, see Definitions.
 * <br><br>
 * Syntax:
 * <br>clientkick clid={clientID}… reasonid={4|5} [reasonmsg={text}]
 */
public class ClientKick extends Command
{
    public ClientKick kick(KickReason reasonid, int... clientId)
    {
        this.setParam("reasonid", reasonid);
        this.setParam("clid", clientId);
        return this;
    }

    public ClientKick withReason(String reasonmsg)
    {
        this.setParam("reasonmsg", reasonmsg);
        return this;
    }
    //Permissions:"i_client_kick_from_server_power i_client_kick_from_channel_power i_client_needed_kick_from_server_power i_client_needed_kick_from_channel_power"
}

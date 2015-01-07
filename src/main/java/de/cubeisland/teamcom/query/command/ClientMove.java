package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;
import de.cubeisland.teamcom.query.TeamComException;
import de.cubeisland.teamcom.query.QueryConnection;

/**
 * Moves one or more clients specified with clid to the channel with ID cid.
 * <br>If the target channel has a password, it needs to be specified with cpw.
 * <br>If the channel has no password, the parameter can be omitted.
 * <br><br>
 * Syntax:
 * <br>clientmove clid={clientID}… cid={channelID} [cpw={channelPassword}]
 */
public class ClientMove extends Command
{
    public ClientMove move(int channelId, String channelPassword, int... clientId)
    {
        this.setParam("cid", channelId);
        this.setParam("cpw", channelPassword);
        this.setParam("clid", clientId);
        return this;
    }
    //Permissions:"i_client_move_power i_client_needed_move_power"


    @Override
    protected String execute(QueryConnection query) throws TeamComException
    {
        String response = super.execute(query);
        if (query.current().isClient(arguments.get("clid")))
        {
            query.current().updateChannel((Integer)arguments.get("cid"), (String)arguments.get("cpw"), query);
        }
        return response;
    }
}

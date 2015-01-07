package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Displays a list of client identities known by the server including their database ID, last nickname, etc.
 * <br><br>
 * Syntax:
 * <br>clientdblist [start={offset}] [duration={limit}] [-count]
 */
public class ClientDbList extends Command
{
    public ClientDbList start(int offset)
    {
        this.setParam("duration", offset);
        return this;
    }

    public ClientDbList duration(int limit)
    {
        this.setParam("duration", limit);
        return this;
    }

    public ClientDbList count()
    {
        this.setFlag("count");
        return this;
    }
    //Permissions:"b_virtualserver_client_dblist"
}

package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Displays a list of clients online on a virtual server including their ID, nickname, status flags, etc.
 * <br>The output can be modified using several command options.
 * <br>Please note that the output will only contain clients which are currently in channels you're able to subscribe to.
 * <br><br>
 * Syntax:
 * <br>clientlist [-uid] [-away] [-voice] [-times] [-groups] [-info] [-icon] [-country]
 */
public class ClientList extends Command
{
    public ClientList county()
    {
        this.setFlag("cid");
        return this;
    }

    public ClientList icon()
    {
        this.setFlag("icon");
        return this;
    }

    public ClientList info()
    {
        this.setFlag("info");
        return this;
    }

    public ClientList groups()
    {
        this.setFlag("groups");
        return this;
    }

    public ClientList times()
    {
        this.setFlag("times");
        return this;
    }

    public ClientList voice()
    {
        this.setFlag("voice");
        return this;
    }

    public ClientList away()
    {
        this.setFlag("away");
        return this;
    }

    public ClientList uid()
    {
        this.setFlag("uid");
        return this;
    }
    //Permissions:"b_virtualserver_client_list i_channel_subscribe_power i_channel_needed_subscribe_power"
}

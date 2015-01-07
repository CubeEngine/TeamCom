package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Adds a new ban rule on the selected virtual server.
 * <br>All parameters are optional but at least one of the following must be set: ip, name, or uid.
 * <br><br>
 * Syntax:
 * <br>banadd [ip={regexp}] [name={regexp}] [uid={clientUID}] [time={timeInSeconds}] [banreason={text}]
 */
public class BanAdd extends Command
{
    public BanAdd addByUId(String uid)
    {
        this.setParam("uid", uid);
        return this;
    }

    public BanAdd addByName(String regex)
    {
        this.setParam("name", regex);
        return this;
    }

    public BanAdd addByIp(String regex)
    {
        this.setParam("ip", regex);
        return this;
    }

    public BanAdd withReason(String reason)
    {
        this.setParam("banreason", reason);
        return this;
    }

    public BanAdd temporary(int seconds)
    {
        this.setParam("time", seconds);
        return this;
    }
    //Permissions:"b_client_ban_create"
}

package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Sets a new temporary server password specified with pw.
 * <br>The temporary password will be valid for the number of seconds specified with duration.
 * <br>The client connecting with this password will automatically join the channel specified with tcid.
 * <br>If tcid is set to 0, the client will join the default channel.
 * <br><br>
 * Syntax:
 * <br>servertemppasswordadd pw={password} desc={description} duration={seconds} tcid={channelID} tcpw={channelPW}
 */
public class ServerTempPasswordAdd extends Command
{
    public ServerTempPasswordAdd set(String pw, String description, int seconds)
    {
        this.setParam("pw", pw);
        this.setParam("desc", description);
        this.setParam("duration", seconds);
        this.forChannel(0, null);
        return this;
    }

    /**
     * Call after {@link #set}
     */
    public ServerTempPasswordAdd forChannel(int cid, String cpw)
    {
        this.setParam("tcid", cid);
        this.setParam("tcpw", cpw);
        return this;
    }
    //Permissions:"b_virtualserver_modify_password"
}

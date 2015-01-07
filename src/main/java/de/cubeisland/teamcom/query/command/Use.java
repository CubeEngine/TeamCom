package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Selects the virtual server specified with sid or port to allow further interaction.
 * <br>The ServerQuery client will appear on the virtual server and acts like a real TeamSpeak 3 Client, except it's unable to send or receive voice data.
 * <br>If your database contains multiple virtual servers using the same UDP port, use will select a random virtual server using the specified port.
 * <br><br>
 * Syntax:
 * <br>use [sid={serverID}] [port={serverPort}] [-virtual]
 * <br>use {serverID} [-virtual]
 */
public class Use extends Command
{
    public Use serverId(int sid)
    {
        this.setParam("sid", sid);
        return this;
    }

    public Use port(int port)
    {
        this.setParam("port", port);
        return this;
    }

    public Use virtual()
    {
        this.setFlag("virtual");
        return this;
    }
    //Permissions:"b_virtualserver_select"
}

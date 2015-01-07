package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Sends a text message to all clients on all virtual servers in the TeamSpeak 3 Server instance.
 * <br><br>
 * Syntax:
 * <br>gm msg={text}
 */
public class Gm extends Command
{
    public Gm sendGlobal(String msg)
    {
        this.setParam("msg", msg);
        return this;
    }
    //Permissions:"b_serverinstance_textmessage_send"
}

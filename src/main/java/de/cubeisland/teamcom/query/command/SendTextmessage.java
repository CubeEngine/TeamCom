package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;
import de.cubeisland.teamcom.query.TeamComException;
import de.cubeisland.teamcom.query.QueryConnection;
import de.cubeisland.teamcom.query.QueryConnection.QueryCurrent;
import de.cubeisland.teamcom.query.value.TargetMode;

/**
 * Sends a text message a specified target.
 * <br>The type of the target is determined by targetmode while target specifies the ID of the recipient, whether it be a virtual server, a channel or a client.
 * <br>For detailed information, see Definitions.
 * <br><br>
 * Syntax:
 * <br>sendtextmessage targetmode={1-3} target={serverID|channelID|clientID} msg={text}
 */
public class SendTextmessage extends Command
{
    public SendTextmessage send(TargetMode mode, int target, String text)
    {
        this.setParam("targetmode", mode);
        this.setParam("target", target);
        this.setParam("msg", text);
        return this;
    }
    //Permissions:"i_client_private_textmessage_power i_client_needed_private_textmessage_power b_client_server_textmessage_send b_client_channel_textmessage_send"

    @Override
    protected String execute(QueryConnection query) throws TeamComException
    {
        String result = null;
        QueryCurrent current = query.current();
        switch ((TargetMode)this.arguments.get("targetmode"))
        {
        case CHANNEL:
            if (!current.isInChannel(arguments.get("target")))
            {
                current.moveToChannel((Integer)arguments.get("target"), query);
                result = super.execute(query);
                current.moveToChannel(null, query);
            }
            break;
        case VIRTUALSERVER:
            if (!current.isOnServer(arguments.get("target")))
            {
                current.chooseServer((Integer)arguments.get("target"), query);
                result = super.execute(query);
                current.chooseServer(null, query);
            }
        }
        if (result == null)
        {
            result = super.execute(query);
        }
        return result;
    }
}

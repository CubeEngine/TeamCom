package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Updates the flag_read property of the offline message specified with msgid.
 * <br>If flag is set to 1, the message will be marked as read.
 * <br><br>
 * Syntax:
 * <br>messageupdateflag msgid={messageID} flag={1|0}
 */
public class MessageUpdateFlag extends Command
{
    public MessageUpdateFlag read(int msgid)
    {
        this.setParam("msgid", msgid);
        this.setParam("flag", 1);
        return this;
    }

    public MessageUpdateFlag unread(int msgid)
    {
        this.setParam("msgid", msgid);
        this.setParam("flag", 0);
        return this;
    }
}

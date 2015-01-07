package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Displays an existing offline message with ID msgid from your inbox.
 * <br>Please note that this does not automatically set the flag_read property of the message.
 * <br><br>
 * Syntax:
 * <br>messageget msgid={messageID}
 */
public class MessageGet extends Command
{
    public MessageGet by(int messageId)
    {
        this.setParam("msgid", messageId);
        return this;
    }
}

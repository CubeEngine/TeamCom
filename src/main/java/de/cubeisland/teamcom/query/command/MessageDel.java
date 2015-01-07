package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Deletes an existing offline message with ID msgid from your inbox.
 * <br><br>
 * Syntax:
 * <br>messagedel msgid={messageID}
 */
public class MessageDel extends Command
{
    public MessageDel by(int messageId)
    {
        this.setParam("msgid", messageId);
        return this;
    }
}

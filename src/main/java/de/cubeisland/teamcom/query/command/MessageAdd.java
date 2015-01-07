package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Sends an offline message to the client specified by cluid.
 * <br><br>
 * Syntax:
 * <br>messageadd cluid={clientUID} subject={subject} message={text}
 */
public class MessageAdd extends Command
{
    public MessageAdd add(String subject, String message, String clientUId)
    {
        this.setParam("subject", subject);
        this.setParam("message", message);
        this.setParam("cluid", clientUId);
        return this;
    }
}

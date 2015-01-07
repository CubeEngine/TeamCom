package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;
import de.cubeisland.teamcom.query.value.EventMode;

/**
 * Registers for a specified category of events on a virtual server to receive notification messages.
 * <br>Depending on the notifications you've registered for, the server will send you a message on every event in the view of your ServerQuery client (e.g. clients joining your channel, incoming text messages, server configuration changes, etc).
 * <br>The event source is declared by the event parameter while id can be used to limit the notifications to a specific channel.
 * <br><br>
 * Syntax:
 * <br>servernotifyregister event={server|channel|textserver|textchannel|textprivate} [id={channelID}]
 */
public class ServerNotifyRegister extends Command
{
    public ServerNotifyRegister eventChannel(EventMode mode, int channel)
    {
        this.event(mode);
        this.setParam("id", channel);
        return this;
    }

    public ServerNotifyRegister event(EventMode mode)
    {
        if (mode == EventMode.CHANNEL)
        {
            throw new IllegalArgumentException("Use eventChannel() instead!");
        }
        this.setParam("event", mode);
        return this;
    }
    //Permissions:"b_virtualserver_notify_register"
}

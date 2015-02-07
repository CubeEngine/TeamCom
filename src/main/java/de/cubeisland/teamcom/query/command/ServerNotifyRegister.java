/**
 * The MIT License
 * Copyright (c) 2013 Cube Island
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
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

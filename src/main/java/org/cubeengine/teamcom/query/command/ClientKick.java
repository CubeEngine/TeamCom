/*
 * The MIT License
 * Copyright © 2013 Cube Island
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
package org.cubeengine.teamcom.query.command;

import org.cubeengine.teamcom.query.Command;
import org.cubeengine.teamcom.query.value.KickReason;

/**
 * Kicks one or more clients specified with clid from their currently joined channel or from the server, depending on reasonid.
 * <br>The reasonmsg parameter specifies a text message sent to the kicked clients.
 * <br>This parameter is optional and may only have a maximum of 40 characters.
 * <br>For detailed information, see Definitions.
 * <br><br>
 * Syntax:
 * <br>clientkick clid={clientID}… reasonid={4|5} [reasonmsg={text}]
 */
public class ClientKick extends Command
{
    public ClientKick kick(KickReason reasonid, int... clientId)
    {
        this.setParam("reasonid", reasonid);
        this.setParam("clid", clientId);
        return this;
    }

    public ClientKick withReason(String reasonmsg)
    {
        this.setParam("reasonmsg", reasonmsg);
        return this;
    }
    //Permissions:"i_client_kick_from_server_power i_client_kick_from_channel_power i_client_needed_kick_from_server_power i_client_needed_kick_from_channel_power"
}

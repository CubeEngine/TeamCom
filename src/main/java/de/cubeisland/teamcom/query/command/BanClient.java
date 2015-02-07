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

/**
 * Bans the client specified with ID clid from the server.
 * <br>Please note that this will create two separate ban rules for the targeted clients IP address and his unique identifier.
 * <br><br>
 * Syntax:
 * <br>banclient clid={clientID} [time={timeInSeconds}] [banreason={text}]
 */
public class BanClient extends Command
{
    public BanClient ban(int clientId)
    {
        this.setParam("clid", clientId);
        return this;
    }

    public BanClient withReason(String reason)
    {
        this.setParam("banreason", reason);
        return this;
    }

    public BanClient temporary(int seconds)
    {
        this.setParam("time", seconds);
        return this;
    }
    //Permissions:"i_client_ban_power i_client_needed_ban_power"
}

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
import de.cubeisland.teamcom.query.TeamComException;
import de.cubeisland.teamcom.query.QueryConnection;

/**
 * Moves one or more clients specified with clid to the channel with ID cid.
 * <br>If the target channel has a password, it needs to be specified with cpw.
 * <br>If the channel has no password, the parameter can be omitted.
 * <br><br>
 * Syntax:
 * <br>clientmove clid={clientID}… cid={channelID} [cpw={channelPassword}]
 */
public class ClientMove extends Command
{
    public ClientMove move(int channelId, String channelPassword, int... clientId)
    {
        this.setParam("cid", channelId);
        this.setParam("cpw", channelPassword);
        this.setParam("clid", clientId);
        return this;
    }
    //Permissions:"i_client_move_power i_client_needed_move_power"


    @Override
    protected String execute(QueryConnection query) throws TeamComException
    {
        String response = super.execute(query);
        if (query.current().isClient(arguments.get("clid")))
        {
            query.current().updateChannel((Integer)arguments.get("cid"), (String)arguments.get("cpw"), query);
        }
        return response;
    }
}

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
import org.cubeengine.teamcom.query.exception.TeamComException;
import org.cubeengine.teamcom.query.QueryConnection;

/**
 * Deletes an existing channel by ID.
 * <br>If force is set to 1, the channel will be deleted even if there are clients within.
 * <br>The clients will be kicked to the default channel with an appropriate reason message.
 * <br><br>
 * Syntax:
 * <br>channeldelete cid={channelID} force={1|0}
 */
public class ChannelDelete extends Command
{
    public ChannelDelete delete(int channelId, boolean force)
    {
        this.setParam("cid", channelId);
        this.setParam("force", force);
        return this;
    }
    //Permissions:"b_channel_delete_permanent b_channel_delete_semi_permanent b_channel_delete_temporary b_channel_delete_flag_force"

    @Override
    protected String execute(QueryConnection query) throws TeamComException
    {
        String response = super.execute(query);
        if (query.getCurrent().isInChannel(this.arguments.get("cid")))
        {
            query.updateCurrent();
        }
        return response;
    }
}

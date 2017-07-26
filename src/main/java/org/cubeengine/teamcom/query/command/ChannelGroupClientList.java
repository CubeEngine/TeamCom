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

/**
 * Displays all the client and/or channel IDs currently assigned to channel groups.
 * <br>All three parameters are optional so you're free to choose the most suitable combination for your requirements.
 * <br><br>
 * Syntax:
 * <br>channelgroupclientlist [cid={channelID}] [cldbid={clientDBID}] [cgid={groupID}]
 */
public class ChannelGroupClientList extends Command
{
    public ChannelGroupClientList byChannelId(int channelId)
    {
        this.setParam("cid", channelId);
        return this;
    }

    public ChannelGroupClientList byClientDBId(int clientDBId)
    {
        this.setParam("cldbid", clientDBId);
        return this;
    }

    public ChannelGroupClientList byChannelGroupId(int channelGroupId)
    {
        this.setParam("cgid", channelGroupId);
        return this;
    }
    //Permissions:"b_virtualserver_channelgroup_client_list"
}

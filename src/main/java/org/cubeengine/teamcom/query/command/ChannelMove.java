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
 * Moves a channel to a new parent channel with the ID cpid.
 * <br>If order is specified, the channel will be sorted right under the channel with the specified ID.
 * <br>If order is set to 0, the channel will be sorted right below the new parent.
 * <br><br>
 * Syntax:
 * <br>channelmove cid={channelID} cpid={channelParentID} [order={channelSortOrder}]
 */
public class ChannelMove extends Command
{
    public ChannelMove channelId(int channelId, int channelParentId)
    {
        this.setParam("cid", channelId);
        this.setParam("cpid", channelParentId);
        return this;
    }

    public ChannelMove under(int channelId)
    {
        this.setParam("order", channelId);
        return this;
    }

    public ChannelMove underParent()
    {
        return this.under(0);
    }
    //Permissions:"i_channel_min_depth i_channel_max_depth b_channel_modify_parent b_channel_modify_sortorder"
}

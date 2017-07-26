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
 * Sets the channel group of a client to the ID specified with cgid.
 * <br><br>
 * Syntax:
 * <br>setclientchannelgroup cgid={groupID} cid={channelID} cldbid={clientDBID}
 */
public class SetClientChannelGroup extends Command
{
    public SetClientChannelGroup set(int channelGroupId, int channelId, int clientDBId)
    {
        this.setParam("cgid", channelGroupId);
        this.setParam("cid", channelId);
        this.setParam("cldbid", clientDBId);
        return this;
    }
    //Permissions:"i_group_member_add_power i_group_needed_member_add_power i_group_member_remove_power i_group_needed_member_remove_power"
}

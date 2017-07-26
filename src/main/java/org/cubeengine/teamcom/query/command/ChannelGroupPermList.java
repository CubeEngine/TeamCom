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
 * Displays a list of permissions assigned to the channel group specified with cgid.
 * <br>If the –permsid option is specified, the output will contain the permission names instead of the internal IDs.
 * <br><br>
 * Syntax:
 * <br>channelgrouppermlist cgid={groupID} [-permsid]
 */
public class ChannelGroupPermList extends Command
{
    public ChannelGroupPermList listNames(int channelGroupId)
    {
        this.list(channelGroupId);
        this.setFlag("permsid");
        return this;
    }

    public ChannelGroupPermList list(int channelGroupId)
    {
        this.setParam("cgid", channelGroupId);
        return this;
    }
    //Permissions:"b_virtualserver_channelgroup_permission_list"
}

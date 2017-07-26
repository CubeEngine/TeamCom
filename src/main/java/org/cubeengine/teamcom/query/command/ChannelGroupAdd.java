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
import org.cubeengine.teamcom.query.value.PermissionGroupDatabaseType;

/**
 * Creates a new channel group using a given name and displays its ID.
 * <br>The optional type parameter can be used to create ServerQuery groups and template groups.
 * <br><br>
 * Syntax:
 * <br>channelgroupadd name={groupName} [type={groupDbType}]
 */
public class ChannelGroupAdd extends Command
{
    public ChannelGroupAdd add(String name)
    {
        this.setParam("name", name);
        return this;
    }

    public ChannelGroupAdd add(String name, PermissionGroupDatabaseType type)
    {
        this.add(name);
        this.setParam("type", type);
        return this;
    }
    //Permissions:"b_virtualserver_channelgroup_create"
}

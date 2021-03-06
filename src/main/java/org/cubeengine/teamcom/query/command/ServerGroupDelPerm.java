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
 * Removes a set of specified permissions from the server group specified with sgid.
 * <br>Multiple permissions can be removed at once. A permission can be specified by permid or permsid.
 * <br><br>
 * Syntax:
 * <br>servergroupdelperm sgid={groupID} [permid={permID}…] [permsid={permName}…]
 */
public class ServerGroupDelPerm extends Command
{
    public ServerGroupDelPerm removeById(int serverGroupId, int... permissionId)
    {
        this.setParam("sgid", serverGroupId);
        this.setParam("permid", permissionId);
        return this;
    }

    public ServerGroupDelPerm removeByName(int sgid, String... permissionName)
    {
        this.setParam("sgid", sgid);
        this.setParam("permsid", permissionName);
        return this;
    }
    //Permissions:"i_group_modify_power i_group_needed_modify_power i_permission_modify_power"
}

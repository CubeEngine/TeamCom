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
 * Removes a set of specified permissions from *ALL* regular server groups on all virtual servers.
 * <br>The target groups will be identified by the value of their i_group_auto_update_type permission specified with sgtype.
 * <br>Multiple permissions can be added at once. A permission can be specified by permid or permsid.
 * <br>The known values for sgtype are:
 * <br>10: Channel Guest
 * <br>15: Server Guest
 * <br>20: Query Guest
 * <br>25: Channel Voice
 * <br>30: Server Normal
 * <br>35: Channel Operator
 * <br>40: Channel Admin
 * <br>45: Server Admin
 * <br>50: Query Admin
 * <br><br>
 * Syntax:
 * <br>servergroupautoaddperm sgtype={groupID} [permid={permID}…] [permsid={permName}…]
 */
public class ServerGroupAutoDelPerm extends Command
{
    public ServerGroupAutoDelPerm removeById(int serverGroupType, int... permissionId)
    {
        this.setParam("sgtype", serverGroupType);
        this.setParam("permid", permissionId);
        return this;
    }

    public ServerGroupAutoDelPerm removeByName(int serverGroupType, String... name)
    {
        this.setParam("sgtype", serverGroupType);
        this.setParam("permsid", name);
        return this;
    }
    //Permissions:"b_permission_modify_power_ignore"
}

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
 * Adds a set of specified permissions to the server group specified with sgid.
 * <br>Multiple permissions can be added by providing the four parameters of each permission.
 * <br>A permission can be specified by permid or permsid
 * <br><br>
 * Syntax:
 * <br>servergroupaddperm sgid={groupID} [permid={permID}…] [permsid={permName}…] permvalue={permValue}… permnegated={1|0}… permskip={1|0}…
 */
public class ServerGroupAddPerm extends Command
{
    public ServerGroupAddPerm addById(int serverGroupId, int permissionId, String value, boolean negate, boolean skip)
    {
        this.setParam("sgid", serverGroupId);
        this.setParam("permid", permissionId);
        this.setParam("permvalue", value);
        this.setParam("permnegated", negate);
        this.setParam("permskip", skip);
        return this;
    }

    public ServerGroupAddPerm addByName(int serverGroupId, String permissionName, String value, boolean negate,
                                        boolean skip)
    {
        this.setParam("sgid", serverGroupId);
        this.setParam("permsid", permissionName);
        this.setParam("permvalue", value);
        this.setParam("permnegated", negate);
        this.setParam("permskip", skip);
        return this;
    }
    //Permissions:"i_group_modify_power i_group_needed_modify_power i_permission_modify_power"
}

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
 * Displays all permissions assigned to a client for the channel specified with cid.
 * <br>If permid is set to 0, all permissions will be displayed.
 * <br>A permission can be specified by permid or permsid.
 * <br><br>
 * Syntax:
 * <br>permoverview cid={channelID} cldbid={clientDBID} [permid={permID}…] [permsid={permName}…]
 */
public class PermOverview extends Command
{
    public PermOverview overview(int channelId, int clientDBId, int... permissionId)
    {
        this.setParam("cid", channelId);
        this.setParam("cldbid", clientDBId);
        this.setParam("permid", permissionId);
        return this;
    }

    public PermOverview overview(int channelId, int clientDBId, String... permissionName)
    {
        this.setParam("cid", channelId);
        this.setParam("cldbid", clientDBId);
        this.setParam("permsid", permissionName);
        return this;
    }
    //Permissions:"b_client_permissionoverview_view"
}

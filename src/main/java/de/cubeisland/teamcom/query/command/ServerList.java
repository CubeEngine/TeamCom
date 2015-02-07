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
 * Displays a list of virtual servers including their ID, status, number of clients online, etc.
 * <br>If you're using the -all option, the server will list all virtual servers stored in the database.
 * <br>This can be useful when multiple server instances with different machine IDs are using the same database.
 * <br>The machine ID is used to identify the server instance a virtual server is associate.
 * <br>The status of a virtual server can be either online, offline, deploy running, booting up, shutting down and virtual online.
 * <br>While most of them are self‐explanatory, virtual online is a bit more complicated.
 * <br>Please note that whenever you select a virtual server which is currently stopped, it will be started in virtual mode which means you are able to change its configuration, create channels or change permissions, but no regular TeamSpeak 3 Client can connect.
 * <br>As soon as the last ServerQuery client deselects the virtual server, its status will be changed back to offline.
 * <br><br>
 * Syntax:
 * <br>serverlist [-uid] [-short] [-all] [-onlyoffline]
 */
public class ServerList extends Command
{
    public ServerList uid()
    {
        this.setFlag("uid");
        return this;
    }

    public ServerList all()
    {
        this.setFlag("all");
        return this;
    }

    public ServerList shortFlag()
    {
        this.setFlag("short");
        return this;
    }

    public ServerList onylyoffline()
    {
        this.setFlag("onlyoffline");
        return this;
    }
    //Permissions:"b_serverinstance_virtualserver_list"
}

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
 * Selects the virtual server specified with sid or port to allow further interaction.
 * <br>The ServerQuery client will appear on the virtual server and acts like a real TeamSpeak 3 Client, except it's unable to send or receive voice data.
 * <br>If your database contains multiple virtual servers using the same UDP port, use will select a random virtual server using the specified port.
 * <br><br>
 * Syntax:
 * <br>use [sid={serverID}] [port={serverPort}] [-virtual]
 * <br>use {serverID} [-virtual]
 */
public class Use extends Command
{
    public Use serverId(int sid)
    {
        this.setParam("sid", sid);
        return this;
    }

    public Use port(int port)
    {
        this.setParam("port", port);
        return this;
    }

    public Use virtual()
    {
        this.setFlag("virtual");
        return this;
    }
    //Permissions:"b_virtualserver_select"
}

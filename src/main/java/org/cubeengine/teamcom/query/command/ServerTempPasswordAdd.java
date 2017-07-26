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
 * Sets a new temporary server password specified with pw.
 * <br>The temporary password will be valid for the number of seconds specified with duration.
 * <br>The client connecting with this password will automatically join the channel specified with tcid.
 * <br>If tcid is set to 0, the client will join the default channel.
 * <br><br>
 * Syntax:
 * <br>servertemppasswordadd pw={password} desc={description} duration={seconds} tcid={channelID} tcpw={channelPW}
 */
public class ServerTempPasswordAdd extends Command
{
    public ServerTempPasswordAdd set(String pw, String description, int seconds)
    {
        this.setParam("pw", pw);
        this.setParam("desc", description);
        this.setParam("duration", seconds);
        this.forChannel(0, null);
        return this;
    }

    /**
     * Call after {@link #set}
     */
    public ServerTempPasswordAdd forChannel(int cid, String cpw)
    {
        this.setParam("tcid", cid);
        this.setParam("tcpw", cpw);
        return this;
    }
    //Permissions:"b_virtualserver_modify_password"
}

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
import org.cubeengine.teamcom.query.value.LogLevel;

/**
 * Writes a custom entry into the servers log.
 * <br>Depending on your permissions, you'll be able to add entries into the server instance log and/or your virtual servers log.
 * <br>The loglevel parameter specifies the type of the entry.
 * <br><br>
 * Syntax:
 * <br>logadd loglevel={1-4} logmsg={text}
 */
public class LogAdd extends Command
{
    public LogAdd log(LogLevel level, String msg)
    {
        this.setParam("loglevel", level);
        this.setParam("logmsg", msg);
        return this;
    }
    //Permissions:"b_serverinstance_log_add b_virtualserver_log_add"
}

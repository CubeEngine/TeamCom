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
 * DDisplays a specified number of entries from the servers log.
 * <br>If instance is set to 1, the server will return lines from the master logfile (ts3server_0.log) instead of the selected virtual server logfile.
 * <br><br>
 * Syntax:
 * <br>logview [lines={1-100}] [reverse={1|0}] [instance={1|0}] [begin_pos={n}]
 */
public class LogView extends Command
{
    public LogView lines(int lines)
    {
        if (lines < 1 || lines > 100)
        {
            throw new IllegalArgumentException("lines has to be 1-100");
        }
        this.setParam("lines", lines);
        return this;
    }

    public LogView reverse(boolean reverse)
    {
        this.setParam("reverse", reverse);
        return this;
    }

    public LogView instance(boolean instance)
    {
        this.setParam("instance", instance);
        return this;
    }

    public LogView beginPos(int pos)
    {
        if (pos < 0)
        {
            throw new IllegalArgumentException("Position cannot be negative");
        }
        this.setParam("begin_pos", pos);
        return this;
    }
    //Permissions:"b_serverinstance_log_view b_virtualserver_log_view"
}

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
 * Updates the flag_read property of the offline message specified with msgid.
 * <br>If flag is set to 1, the message will be marked as read.
 * <br><br>
 * Syntax:
 * <br>messageupdateflag msgid={messageID} flag={1|0}
 */
public class MessageUpdateFlag extends Command
{
    public MessageUpdateFlag read(int msgid)
    {
        this.setParam("msgid", msgid);
        this.setParam("flag", 1);
        return this;
    }

    public MessageUpdateFlag unread(int msgid)
    {
        this.setParam("msgid", msgid);
        this.setParam("flag", 0);
        return this;
    }
}

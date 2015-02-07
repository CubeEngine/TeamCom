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
 * Displays a list of channels created on a virtual server including their ID, order, name, etc.
 * <br>The output can be modified using several command options.
 * <br><br>
 * Syntax:
 * <br>channellist [-topic] [-flags] [-voice] [-limits] [-icon]
 */
public class ChannelList extends Command
{
    public ChannelList icon()
    {
        this.setFlag("icon");
        return this;
    }

    public ChannelList limits()
    {
        this.setFlag("limits");
        return this;
    }

    public ChannelList voice()
    {
        this.setFlag("voice");
        return this;
    }

    public ChannelList flags()
    {
        this.setFlag("voice");
        return this;
    }

    public ChannelList topic()
    {
        this.setFlag("voice");
        return this;
    }
    //Permissions:"b_virtualserver_channel_list"
}

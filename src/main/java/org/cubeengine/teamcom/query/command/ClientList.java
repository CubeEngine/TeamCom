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
 * Displays a list of clients online on a virtual server including their ID, nickname, status flags, etc.
 * <br>The output can be modified using several command options.
 * <br>Please note that the output will only contain clients which are currently in channels you're able to subscribe to.
 * <br><br>
 * Syntax:
 * <br>clientlist [-uid] [-away] [-voice] [-times] [-groups] [-info] [-icon] [-country]
 */
public class ClientList extends Command
{
    public ClientList county()
    {
        this.setFlag("cid");
        return this;
    }

    public ClientList icon()
    {
        this.setFlag("icon");
        return this;
    }

    public ClientList info()
    {
        this.setFlag("info");
        return this;
    }

    public ClientList groups()
    {
        this.setFlag("groups");
        return this;
    }

    public ClientList times()
    {
        this.setFlag("times");
        return this;
    }

    public ClientList voice()
    {
        this.setFlag("voice");
        return this;
    }

    public ClientList away()
    {
        this.setFlag("away");
        return this;
    }

    public ClientList uid()
    {
        this.setFlag("uid");
        return this;
    }
    //Permissions:"b_virtualserver_client_list i_channel_subscribe_power i_channel_needed_subscribe_power"
}

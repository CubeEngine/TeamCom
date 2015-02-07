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
package de.cubeisland.teamcom;

import java.util.ArrayList;
import java.util.List;

public class Channel
{
    public final int cid;
    public final String name;
    public final int clients;
    public final int max_clients;
    public final int pid;

    public final List<Client> clientList = new ArrayList<Client>();
    public final List<Integer> channels = new ArrayList<Integer>();

    public Channel(String name, String cid, String total_clients, String channel_maxclients, String pid)
    {
        this.name = name;
        this.cid = Integer.valueOf(cid);
        this.clients = Integer.valueOf(total_clients);
        this.max_clients = Integer.valueOf(channel_maxclients);
        this.pid = Integer.valueOf(pid);
    }
}

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
package de.cubeisland.teamcom.query;

import java.net.InetAddress;

public class QueryConnectionBuilder
{
    public static final int NO_DEFAULT_VIRTUAL_SERVER = -1;
    public static final int DEFAULT_TIMEOUT = 10000;

    private InetAddress address;
    private int queryPort;
    private int fileTransferPort;

    private String username;
    private String password;
    private String displayName;
    private int defaultVirtualServer = NO_DEFAULT_VIRTUAL_SERVER;
    private Integer timeout = DEFAULT_TIMEOUT;


    public QueryConnection build()
    {
        return new QueryConnection(address, queryPort, username, password, displayName, defaultVirtualServer, timeout);
    }

    public QueryConnectionBuilder withAddress(InetAddress addr)
    {
        this.address = addr;
        return this;
    }

    public QueryConnectionBuilder withQueryPort(int port)
    {
        if (port < 0 || port > 65535)
        {
            throw new IllegalArgumentException("Port not within legal range!");
        }
        this.queryPort = port;
        return this;
    }

    public QueryConnectionBuilder withFileTransferPort(int port)
    {
        if (port < 0 || port > 65535)
        {
            throw new IllegalArgumentException("Port not within legal range!");
        }
        this.fileTransferPort = port;
        return this;
    }

    public QueryConnectionBuilder withCredentials(String username, String password)
    {
        this.username = username;
        this.password = password;
        return this;
    }

    public QueryConnectionBuilder withDisplayName(String displayName)
    {
        this.displayName = displayName;
        return this;
    }

    public QueryConnectionBuilder withDefaultVirtualServer(int id)
    {
        this.defaultVirtualServer = id >= 0 ? id : NO_DEFAULT_VIRTUAL_SERVER;
        return this;
    }

    public QueryConnectionBuilder withTimeout(int timeout)
    {
        this.timeout = Math.abs(timeout);
        return this;
    }
}

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

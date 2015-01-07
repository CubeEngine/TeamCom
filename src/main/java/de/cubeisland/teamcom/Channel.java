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

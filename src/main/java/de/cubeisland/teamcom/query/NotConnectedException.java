package de.cubeisland.teamcom.query;

public class NotConnectedException extends TeamComException
{
    public NotConnectedException()
    {
        super("Not connected to TS3 server!");
    }
}

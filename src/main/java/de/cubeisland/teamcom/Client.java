package de.cubeisland.teamcom;

public class Client
{
    public final String name;
    public final boolean out_mute;
    public final boolean in_mute;
    public final String[] client_servergroups;

    public Client(String name, String out_mute, String in_mute, String client_servergroups)
    {
        this.name = name.replace(" ", "&nbsp;");
        this.out_mute = "1".equals(out_mute);
        this.in_mute =  "1".equals(in_mute);
        this.client_servergroups = client_servergroups.split(",");
    }
}

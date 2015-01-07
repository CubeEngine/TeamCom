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

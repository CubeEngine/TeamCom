package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Displays a list of channels matching a given name pattern.
 * <br><br>
 * Syntax:
 * <br>channelfind [pattern={channelName}]
 */
public class ChannelFind extends Command
{
    public ChannelFind with(String pattern)
    {
        this.setParam("pattern", pattern);
        return this;
    }
    //Permissions:"b_virtualserver_channel_search"
}

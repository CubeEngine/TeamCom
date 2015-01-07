package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;
import de.cubeisland.teamcom.query.value.PermissionGroupDatabaseType;

/**
 * Creates a new channel group using a given name and displays its ID.
 * <br>The optional type parameter can be used to create ServerQuery groups and template groups.
 * <br><br>
 * Syntax:
 * <br>channelgroupadd name={groupName} [type={groupDbType}]
 */
public class ChannelGroupAdd extends Command
{
    public ChannelGroupAdd add(String name)
    {
        this.setParam("name", name);
        return this;
    }

    public ChannelGroupAdd add(String name, PermissionGroupDatabaseType type)
    {
        this.add(name);
        this.setParam("type", type);
        return this;
    }
    //Permissions:"b_virtualserver_channelgroup_create"
}

package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Adds a client to the server group specified with sgid.
 * <br>Please note that a client cannot be added to default groups or template groups.
 * <br><br>
 * Syntax:
 * <br>servergroupaddclient sgid={groupID} cldbid={clientDBID}
 */
public class ServerGroupAddClient extends Command
{
    public ServerGroupAddClient add(int serverGroupId, int clientDBId)
    {
        this.setParam("sgid", serverGroupId);
        this.setParam("cldbid", clientDBId);
        return this;
    }
    //Permissions:"i_group_member_add_power i_group_needed_member_add_power"
}

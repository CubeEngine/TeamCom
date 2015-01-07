package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Removes a client specified with cldbid from the server group specified with sgid.
 * <br><br>
 * Syntax:
 * <br>servergroupdelclient sgid={groupID} cldbid={clientDBID}
 */
public class ServerGroupDelClient extends Command
{
    public ServerGroupDelClient remove(int serverGroupId, int clientDBId)
    {
        this.setParam("sgid", serverGroupId);
        this.setParam("cldbid", clientDBId);
        return this;
    }
    //Permissions:"i_group_member_remove_power i_group_needed_member_remove_power"
}

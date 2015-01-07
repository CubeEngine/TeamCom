package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Deletes the server group specified with sgid.
 * <br>If force is set to 1, the server group will be deleted even if there are clients within.
 * <br><br>
 * Syntax:
 * <br>servergroupdel sgid={groupID} force={1|0}
 */
public class ServerGroupDel extends Command
{
    public ServerGroupDel delete(int serverGroupId, boolean force)
    {
        this.setParam("sgid", serverGroupId);
        this.setParam("force", force);
        return this;
    }
    //Permissions:"b_virtualserver_servergroup_delete"
}

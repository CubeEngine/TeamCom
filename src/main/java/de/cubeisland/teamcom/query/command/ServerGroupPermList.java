package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Displays a list of permissions assigned to the server group specified with sgid.
 * <br>If the –permsid option is specified, the output will contain the permission names instead of the internal IDs.
 * <br><br>
 * Syntax:
 * <br>servergrouppermlist sgid={groupID} [-permsid]
 */
public class ServerGroupPermList extends Command
{
    public ServerGroupPermList list(int serverGroupId)
    {
        this.setParam("sgid", serverGroupId);
        return this;
    }

    public ServerGroupPermList listNames(int serverGroupId)
    {
        this.setFlag("permsid");
        return this.list(serverGroupId);
    }
    //Permissions:"b_virtualserver_servergroup_permission_list"
}

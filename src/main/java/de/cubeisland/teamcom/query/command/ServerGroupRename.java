package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Changes the name of the server group specified with sgid.
 * <br><br>
 * Syntax:
 * <br>servergrouprename sgid={groupID} name={groupName}
 */
public class ServerGroupRename extends Command
{
    public ServerGroupRename rename(int serverGroupId, String newName)
    {
        this.setParam("sgid", serverGroupId);
        this.setParam("name", newName);
        return this;
    }
    //Permissions:"i_group_modify_power i_group_needed_modify_power"
}

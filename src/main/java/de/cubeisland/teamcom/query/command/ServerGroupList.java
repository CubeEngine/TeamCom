package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Displays a list of server groups available.
 * <br>Depending on your permissions, the output may also contain global ServerQuery groups and template groups.
 * <br><br>
 * Syntax: servergrouplist
 */
public class ServerGroupList extends Command
{
    //Permissions:"b_serverinstance_modify_querygroup", "b_serverinstance_modify_templates", "b_virtualserver_servergroup_list"
}

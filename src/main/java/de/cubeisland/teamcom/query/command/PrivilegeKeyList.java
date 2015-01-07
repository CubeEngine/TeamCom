package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Displays a list of privilege keys available including their type and group IDs.
 * <br>Tokens can be used to gain access to specified server or channel groups.
 * <br>A privilege key is similar to a client with administrator privileges that adds you to a certain permission group,
 * <br>but without the necessity of a such a client with administrator privileges to actually exist.
 * <br>It is a long (random looking) string that can be used as a ticket into a specific server group.
 * <br><br>
 * Syntax: privilegekeylist
 */
public class PrivilegeKeyList extends Command
{
    //Permissions:"b_virtualserver_token_list"
}

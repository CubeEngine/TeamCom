package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Displays a snapshot of the selected virtual server containing all settings, groups and known client identities.
 * <br>The data from a server snapshot can be used to restore a virtual servers configuration, channels and permissions using the serversnapshotdeploy command.
 * <br><br>
 * Syntax: serversnapshotcreate
 */
public class ServerSnapshotCreate extends Command
{
    //Permissions:"b_virtualserver_snapshot_create"
}

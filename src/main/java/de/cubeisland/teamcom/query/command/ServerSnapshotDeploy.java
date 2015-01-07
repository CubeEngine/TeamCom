package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Restores the selected virtual servers configuration using the data from a previously created server snapshot.
 * <br>Please note that the TeamSpeak 3 Server does NOT check for necessary permissions while deploying a snapshot so the command could be abused to gain additional privileges.
 * <br><br>
 * Syntax: serversnapshotdeploy virtualserver_snapshot
 */
public class ServerSnapshotDeploy extends Command
{
    //Permissions:"b_virtualserver_snapshot_deploy"
    // TODO arg???
}

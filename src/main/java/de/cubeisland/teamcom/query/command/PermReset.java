package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Restores the default permission settings on the selected virtual server and creates a new initial administrator token.
 * <br>Please note that in case of an error during the permreset call ‐ e.g. when the database has been modified or corrupted ‐ the virtual server will be deleted from the database.
 * <br><br>
 * Syntax: permreset
 */
public class PermReset extends Command
{
    //Permissions:"b_virtualserver_permission_reset"
}

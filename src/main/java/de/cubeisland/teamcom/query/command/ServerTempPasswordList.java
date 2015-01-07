package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Returns a list of active temporary server passwords.
 * <br>The output contains the clear‐text password, the nickname and unique identifier of the creating client.
 * <br><br>
 * Syntax:
 * <br>servertemppasswordlist
 */
public class ServerTempPasswordList extends Command
{
    //Permissions:"b_virtualserver_modify_password"
}

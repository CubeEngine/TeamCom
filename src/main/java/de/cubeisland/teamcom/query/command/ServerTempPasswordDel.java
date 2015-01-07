package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Deletes the temporary server password specified with pw.
 * <br><br>
 * Syntax:
 * <br>servertemppassworddel pw={password}
 */
public class ServerTempPasswordDel extends Command
{
    public ServerTempPasswordDel delete(String password)
    {
        this.setParam("pw", password);
        return this;
    }
    //Permissions:"b_virtualserver_modify_password"
}

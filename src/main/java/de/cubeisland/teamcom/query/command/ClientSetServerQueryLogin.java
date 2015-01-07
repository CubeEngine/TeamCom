package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Updates your own ServerQuery login credentials using a specified username.
 * <br>The password will be auto‐generated.
 * <br><br>
 * Syntax:
 * <br>clientsetserverquerylogin client_login_name={username}
 */
public class ClientSetServerQueryLogin extends Command
{
    public ClientSetServerQueryLogin name(String loginName)
    {
        this.setParam("client_login_name", loginName);
        return this;
    }
    //Permissions:"b_client_create_modify_serverquery_login"
}

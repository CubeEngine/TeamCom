package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Authenticates with the TeamSpeak 3 Server instance using given ServerQuery login credentials.
 * <br><br>
 * Syntax:
 * <br>login client_login_name={username} client_login_password={password}
 * <br>login {username} {password}
 */
public class Login extends Command
{
    public Login with(String login, String pw)
    {
        this.setParam("client_login_name", login);
        this.setParam("client_login_password", pw);
        return this;
    }
    //Permissions:"b_serverquery_login"
}

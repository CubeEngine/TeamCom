package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Use a token key gain access to a server or channel group.
 * <br>Please note that the server will automatically delete the token after it has been used.
 * <br><br>
 * Syntax:
 * <br>privilegekeyuse token={tokenKey}
 */
public class PrivilegeKeyUse extends Command
{
    public PrivilegeKeyUse by(String token)
    {
        this.setParam("token", token);
        return this;
    }
    //Permissions:"b_virtualserver_token_use"
}

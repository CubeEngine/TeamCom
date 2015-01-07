package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Deletes an existing token matching the token key specified with token.
 * <br><br>
 * Syntax:
 * <br>privilegekeydelete token={tokenKey}
 */
public class PrivilegeKeyDelete extends Command
{
    public PrivilegeKeyDelete by(String token)
    {
        this.setParam("token", token);
        return this;
    }
    //Permissions:"b_virtualserver_token_delete"
}

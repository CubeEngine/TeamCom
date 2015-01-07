package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;
import de.cubeisland.teamcom.query.value.LogLevel;

/**
 * Writes a custom entry into the servers log.
 * <br>Depending on your permissions, you'll be able to add entries into the server instance log and/or your virtual servers log.
 * <br>The loglevel parameter specifies the type of the entry.
 * <br><br>
 * Syntax:
 * <br>logadd loglevel={1-4} logmsg={text}
 */
public class LogAdd extends Command
{
    public LogAdd log(LogLevel level, String msg)
    {
        this.setParam("loglevel", level);
        this.setParam("logmsg", msg);
        return this;
    }
    //Permissions:"b_serverinstance_log_add b_virtualserver_log_add"
}

package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * DDisplays a specified number of entries from the servers log.
 * <br>If instance is set to 1, the server will return lines from the master logfile (ts3server_0.log) instead of the selected virtual server logfile.
 * <br><br>
 * Syntax:
 * <br>logview [lines={1-100}] [reverse={1|0}] [instance={1|0}] [begin_pos={n}]
 */
public class LogView extends Command
{
    public LogView lines(int lines)
    {
        if (lines < 1 || lines > 100)
        {
            throw new IllegalArgumentException("lines has to be 1-100");
        }
        this.setParam("lines", lines);
        return this;
    }

    public LogView reverse(boolean reverse)
    {
        this.setParam("reverse", reverse);
        return this;
    }

    public LogView instance(boolean instance)
    {
        this.setParam("instance", instance);
        return this;
    }

    public LogView beginPos(int pos)
    {
        if (pos < 0)
        {
            throw new IllegalArgumentException("Position cannot be negative");
        }
        this.setParam("begin_pos", pos);
        return this;
    }
    //Permissions:"b_serverinstance_log_view b_virtualserver_log_view"
}

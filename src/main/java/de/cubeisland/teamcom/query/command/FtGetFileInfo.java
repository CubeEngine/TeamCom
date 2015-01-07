package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Displays detailed information about one or more specified files stored in a channels file repository.
 * <br><br>
 * Syntax:
 * <br>ftgetfileinfo cid={channelID} cpw={channelPassword} name={filePath}…
 */
public class FtGetFileInfo extends Command
{
    public FtGetFileInfo getList(int channelId, String channelPw, String filePath)
    {
        this.setParam("cid", channelId);
        this.setParam("cpw", channelPw);
        this.setParam("name", filePath);
        return this;
    }
    //Permissions:"i_ft_file_browse_power i_ft_needed_file_browse_power"
}

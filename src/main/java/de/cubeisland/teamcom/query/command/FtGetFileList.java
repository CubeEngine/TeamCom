package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Displays a list of files and directories stored in the specified channels file repository.
 * <br><br>
 * Syntax:
 * <br>ftgetfilelist cid={channelID} cpw={channelPassword} path={filePath}
 */
public class FtGetFileList extends Command
{
    public FtGetFileList getList(int channelId, String channelPw, String filePath)
    {
        this.setParam("cid", channelId);
        this.setParam("cpw", channelPw);
        this.setParam("path", filePath);
        return this;
    }
    //Permissions:"i_ft_file_browse_power i_ft_needed_file_browse_power"
}

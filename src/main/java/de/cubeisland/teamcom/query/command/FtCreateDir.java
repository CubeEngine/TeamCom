package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Creates new directory in a channels file repository.
 * <br><br>
 * Syntax:
 * <br>ftcreatedir cid={channelID} cpw={channelPassword} dirname={dirPath}
 */
public class FtCreateDir extends Command
{
    public FtCreateDir delete(int channelId, String channelPw, String filePath)
    {
        this.setParam("cid", channelId);
        this.setParam("cpw", channelPw);
        this.setParam("dirname", filePath);
        return this;
    }
    //Permissions:"i_ft_directory_create_power i_ft_needed_file_directory_create_power"
}

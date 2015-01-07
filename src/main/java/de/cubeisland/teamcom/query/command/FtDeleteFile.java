package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Deletes one or more files stored in a channels file repository.
 * <br><br>
 * Syntax:
 * <br>ftdeletefile cid={channelID} cpw={channelPassword} name={filePath} …
 */
public class FtDeleteFile extends Command
{
    public FtDeleteFile delete(int channelId, String channelPw, String filePath)
    {
        this.setParam("cid", channelId);
        this.setParam("cpw", channelPw);
        this.setParam("name", filePath);
        return this;
    }
    //Permissions:"i_ft_file_delete_power i_ft_needed_file_delete_power"
}

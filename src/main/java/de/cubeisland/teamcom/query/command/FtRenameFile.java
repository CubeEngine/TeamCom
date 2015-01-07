package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Renames a file in a channels file repository.
 * <br>If the two parameters tcid and tcpw are specified, the file will be moved into another channels file repository.
 * <br><br>
 * Syntax:
 * <br>ftrenamefile cid={channelID} cpw={channelPassword} [tcid={targetChannelID}] [tcpw={targetChannelPassword}] oldname={oldFilePath} newname={newFilePath}
 */
public class FtRenameFile extends Command
{
    public FtRenameFile rename(int channelId, String channelPw, String oldName, String newName)
    {
        this.setParam("cid", channelId);
        this.setParam("cpw", channelPw);
        this.setParam("oldname", oldName);
        this.setParam("newname", newName);
        return this;
    }

    public FtRenameFile andMoveTo(int channelId, String channelPw)
    {
        this.setParam("tcid", channelId);
        this.setParam("tcpw", channelPw);
        return this;
    }
    //Permissions:"i_ft_file_rename_power i_ft_needed_file_re name_power"
}

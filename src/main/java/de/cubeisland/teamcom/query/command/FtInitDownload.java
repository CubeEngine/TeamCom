package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;
import de.cubeisland.teamcom.query.TeamComException;

/**
 * Initializes a file transfer download.
 * <br>clientftfid is an arbitrary ID to identify the file transfer on client‐side.
 * <br>On success, the server generates a new ftkey which is required to start downloading the file through TeamSpeak 3's file transfer interface.
 * <br><br>
 * Syntax:
 * <br>ftinitdownload clientftfid={clientFileTransferID} name={filePath} cid={channelID} cpw={channelPassword} seekpos={seekPosition}
 */
public class FtInitDownload extends Command
{
    public FtInitDownload init(int clientFileTransferId, String filePath, int channelId, String channelPw,
                               int seekpos) throws TeamComException
    {
        this.setParam("clientftfid", clientFileTransferId);
        this.setParam("name", filePath);
        this.setParam("cid", channelId);
        this.setParam("cpw", channelPw);
        this.setParam("seekpos", seekpos);
        return this;
    }
    //Permissions:"i_ft_file_download_power i_ft_needed_file_download _power i_ft_quota_mb_download_per_client"
}

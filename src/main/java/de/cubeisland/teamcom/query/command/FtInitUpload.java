package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Initializes a file transfer upload.
 * <br>clientftfid is an arbitrary ID to identify th e file transfer on client-side.
 * <br>On success, the server generates a new ftkey which is required to start uploading the file through TeamSpeak 3's file transfer interface.
 * <br><br>
 * Syntax:
 * <br>ftinitupload clientftfid={clientFileTransferID} name={filePath} cid={channelID} cpw={channelPassword} size={fileSize} overwrite={1|0} resume={1|0}
 */
public class FtInitUpload extends Command
{
    public FtInitUpload init(int clientFileTransferId, String filePath, int channelId, String channelPw, int size,
                             boolean overwrite, boolean resume)
    {
        this.setParam("clientftfid", clientFileTransferId);
        this.setParam("name", filePath);
        this.setParam("cid", channelId);
        this.setParam("cpw", channelPw);
        this.setParam("size", size);
        this.setParam("overwrite", overwrite);
        this.setParam("resume", resume);
        return this;
    }
    //Permissions:"i_ft_file_upload_power i_ft_needed_file_upload _power i_ft_quota_mb_upload_per_client"
}

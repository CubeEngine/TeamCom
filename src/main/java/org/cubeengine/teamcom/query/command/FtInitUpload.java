/*
 * The MIT License
 * Copyright © 2013 Cube Island
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.cubeengine.teamcom.query.command;

import org.cubeengine.teamcom.query.Command;

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

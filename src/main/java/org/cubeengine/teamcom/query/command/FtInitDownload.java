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
import org.cubeengine.teamcom.query.exception.TeamComException;

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
    public FtInitDownload init(int transferId, String path, int channelId, String channelPassword, int seekOffset) throws TeamComException
    {
        this.setParam("clientftfid", transferId);
        this.setParam("name", path);
        this.setParam("cid", channelId);
        this.setParam("cpw", channelPassword);
        this.setParam("seekpos", seekOffset);
        return this;
    }
    //Permissions:"i_ft_file_download_power i_ft_needed_file_download _power i_ft_quota_mb_download_per_client"
}

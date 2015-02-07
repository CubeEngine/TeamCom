/**
 * The MIT License
 * Copyright (c) 2013 Cube Island
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

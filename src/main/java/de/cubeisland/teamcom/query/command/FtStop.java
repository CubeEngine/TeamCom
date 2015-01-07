package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Stops the running file transfer with server-side ID serverftfid,
 * <br><br>
 * Syntax:
 * <br>ftstop serverftfid={serverFileTransferID} delete={1|0}
 */
public class FtStop extends Command
{
    public FtStop stop(int serverFileTransferId, boolean delete)
    {
        this.setParam("serverftfid", serverFileTransferId);
        this.setParam("delete", delete);
        return this;
    }
}

package de.cubeisland.teamcom.query;

import java.util.Map;

import static de.cubeisland.teamcom.util.StringUtils.decodeString;

/**
 * This Exception is thrown when the TS3 Server returned an Error
 */
public class ServerErrorException extends TeamComException
{
    public ServerErrorException(String message)
    {
        super(message);
    }

    public static TeamComException forResponse(Map<String, String> retValue)
    {
        String message = decodeString(retValue.get("msg"));
        if (retValue.get("extra_msg") != null && retValue.get("extra_msg").length() > 0)
        {
            message += "\n" + decodeString(retValue.get("extra_msg"));
        }
        if (retValue.get("failed_permid") == null)
        {
            return new ServerErrorException("Server returned an Error:" + retValue.get("id") + "\n" + message);
        }
        return new ServerErrorException("Server returned an Missing Permission ID:" + retValue.get("failed_permid") + "Error:" + retValue.get("id") + "\n" + message);
    }
}

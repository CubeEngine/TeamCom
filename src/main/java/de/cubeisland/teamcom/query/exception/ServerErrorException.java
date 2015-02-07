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
package de.cubeisland.teamcom.query.exception;

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

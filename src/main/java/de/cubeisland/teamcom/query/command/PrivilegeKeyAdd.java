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
import de.cubeisland.teamcom.query.value.TokenType;

/**
 * Create a new token.
 * <br>If tokentype is set to 0, the ID specified with tokenid1 will be a server group ID.
 * <br>Otherwise, tokenid1 is used as a channel group ID and you need to provide a valid channel ID using tokenid2.
 * <br>The tokencustomset parameter allows you to specify a set of custom client properties.
 * <br>This feature can be used when generating tokens to combine a website account database with a TeamSpeak user.
 * <br>The syntax of the value needs to be escaped using the ServerQuery escape patterns and has to follow the general syntax of:
 * <br>ident=ident1 value=value1|ident=ident2 value=value2|ident=ident3 value=value3
 * <br><br>
 * Syntax:
 * <br>privilegekey add tokentype={1|0} tokenid1={groupID} tokenid2={channelID} [tokendescription={description}] [tokencustomset={customFieldSet}]
 */
public class PrivilegeKeyAdd extends Command
{
    public PrivilegeKeyAdd add(TokenType type, int groupId, int channelId)
    {
        this.setParam("tokentype", type);
        this.setParam("tokenid1", groupId);
        this.setParam("tokenid2", channelId);
        return this;
    }

    public PrivilegeKeyAdd withDescription(String description)
    {
        this.setParam("tokendescription", description);
        return this;
    }

    public PrivilegeKeyAdd withCustom(String customSet)
    {
        this.setParam("tokencustomset", customSet);
        return this;
    }

    //Permissions:"b_virtualserver_token_add"
}

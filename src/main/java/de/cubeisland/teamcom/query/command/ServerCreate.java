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
import de.cubeisland.teamcom.query.property.VirtualServerProperty;

/**
 * Creates a new virtual server using the given properties and displays its ID, port and initial administrator privilege key.
 * <br>If virtualserver_port is not specified, the server will test for the first unused UDP port.
 * <br>The first virtual server will be running on UDP port 9987 by default.
 * <br>Subsequently started virtual servers will be running on increasing UDP port numbers.
 * <br>For detailed information, see Virtual Server Properties.
 * <br><br>
 * Syntax:
 * <br>servercreate virtualserver_name={serverName} [virtualserver_properties…]
 */
public class ServerCreate extends Command
{
    public ServerCreate name(String name)
    {
        this.setParam("name", name);
        return this;
    }

    public ServerCreate property(VirtualServerProperty property, Object value)
    {
        this.setProperty(property, value);
        return this;
    }
    //Permissions:"b_virtualserver_create"
}

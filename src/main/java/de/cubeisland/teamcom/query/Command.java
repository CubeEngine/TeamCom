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
package de.cubeisland.teamcom.query;

import de.cubeisland.teamcom.query.exception.TeamComException;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import static de.cubeisland.teamcom.util.StringUtils.encode;

public class Command
{
    protected final Map<String, Object> arguments = new HashMap<String, Object>();
    private QueryConnection query;

    /**
     * Binds an argument
     *
     * @param arg the argument
     *
     * @return fluent interface
     */
    public Command addArg(String arg)
    {
        this.arguments.put(arg, null);
        return this;
    }

    /**
     * Binds a flag
     *
     * @param flag the flag
     *
     * @return fluent interface
     */
    public Command setFlag(String flag)
    {
        this.arguments.put("-" + flag, null);
        return this;
    }

    /**
     * Bind a parameter with a value
     * <br>Usually used for parameters
     * <br>e.g.: <code>cid={value}</code>
     *
     * @param param the param
     * @param value the vale
     *
     * @return fluent interface
     */
    public Command setParam(String param, Object value)
    {
        if (value == null)
        {
            value = "";
        }
        this.arguments.put(param, value);
        return this;
    }

    /**
     * Binds a property with a value
     * <br>As used in edit & create commands
     *
     * @param property the property
     * @param value    the value
     *
     * @return fluent interface
     */
    @SuppressWarnings("unchecked")
    protected Command setProperty(Property property, Object value)
    {
        if (!property.accepts(value))
        {
            throw new IllegalArgumentException(property.getName() + " does not accept the value " + value);
        }
        this.arguments.put(property.getName(), value);
        return this;
    }

    /**
     * Converts the command and all bound arguments to a single String to send to the TS3 Server
     *
     * @return the converted String
     */
    @SuppressWarnings("unchecked")
    protected String toRawCommand()
    {
        StringBuilder sb = new StringBuilder(this.getClass().getSimpleName().toLowerCase());
        for (Entry<String, Object> entry : arguments.entrySet())
        {
            sb.append(' ');
            if (entry.getValue() == null) // Flag or Arg
            {
                sb.append(entry.getKey());
            }
            else
            {
                if (entry.getValue() instanceof int[])
                {
                    String separator = "";
                    for (int value : (int[])entry.getValue())
                    {
                        sb.append(separator).append(entry.getKey()).append('=').append(value);
                        separator = "|";
                    }
                }
                else if (entry.getValue() instanceof String[])
                {
                    String separator = "";
                    for (String value : (String[])entry.getValue())
                    {
                        sb.append(separator).append(entry.getKey()).append('=').append(encode(value));
                        separator = "|";
                    }
                }
                else
                {
                    sb.append(entry.getKey()).append('=').append(encode(entry.getValue()));
                }
            }
        }
        return sb.toString();
    }

    public final Response execute() throws TeamComException
    {
        Response response = new Response(this.execute(query));
        this.onExecuted(response, query);
        return response;
    }

    protected void onExecuted(Response response, QueryConnection query)
    {}

    protected String execute(QueryConnection query) throws TeamComException
    {
        return query.executeRawCommand(this.toRawCommand());
    }

    public void setConnection(QueryConnection query)
    {
        this.query = query;
    }
}

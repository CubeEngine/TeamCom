package de.cubeisland.teamcom.query;

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

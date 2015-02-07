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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static de.cubeisland.teamcom.util.StringUtils.decodeString;

public class Response
{
    private String response;

    public Response(String response)
    {
        this.response = response;
    }

    public List<Map<String, String>> asMapList()
    {
        return parseList(response);
    }

    public Map<String, String> asMap()
    {
        return parseLine(response);
    }

    /**
     * Parses the raw response from the TS3 server
     *
     * @param rawResponse the raw response
     *
     * @return a list containing the parsed data
     */
    public static List<Map<String, String>> parseList(String rawResponse)
    {
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        for (String part : rawResponse.split("\\|"))
        {
            list.add(parseLine(part));
        }
        return list;
    }

    /**
     *
     * @param line
     * @return
     * @throws TeamComException
     */
    public static Map<String, String> parseLine(String line)
    {
        if (line == null || line.length() == 0)
        {
            throw new IllegalArgumentException("Cannot parse null or empty line!");
        }
        Map<String, String> retValue = new HashMap<String, String>();
        for (String part : line.split(" "))
        {
            int pos = part.indexOf("=");
            if (pos == -1)
            {
                retValue.put(part, "");
            }
            else
            {
                retValue.put(part.substring(0, pos), decodeString(part.substring(pos + 1)));
            }
        }
        return retValue;
    }
}

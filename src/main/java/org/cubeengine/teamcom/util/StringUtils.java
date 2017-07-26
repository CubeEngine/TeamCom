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
package org.cubeengine.teamcom.util;

import org.cubeengine.teamcom.query.Value;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Provides Utility Methods for encoding and decoding String for the TS3 Server
 */
public class StringUtils
{
    private static final char ESCAPE_CHAR = '\\';
    private static final Map<Character, Character> encodeMap = new HashMap<Character, Character>();
    private static final Map<Character, Character> decodeMap = new HashMap<Character, Character>();

    static
    {
        char[] chars = {
                ESCAPE_CHAR, ESCAPE_CHAR,
                ' ',  's',
                '/',  '/',
                '|',  'p',
                '\b', 'b',
                '\f', 'f',
                '\n', 'n',
                '\r', 'r',
                '\t', 't',
                7,    'a', // \a (Bell not supported by Java)
                11,   'v'  // \v (VTab not supported by Java)
        };

        for (int i = 0; i < chars.length; i += 2)
        {
            encodeMap.put(chars[i], chars[i + 1]);
            decodeMap.put(chars[i + 1], chars[i]);
        }
    }

    /**
     * Escape all special characters for the TS3 server.
     *
     * @param o The String which should be escaped.
     *
     * @return The escaped String
     */
    public static String encode(Object o)
    {
        if (o == null)
        {
            throw new IllegalArgumentException("The object may not be null!");
        }
        String string;
        if (o instanceof Boolean)
        {
            string = (Boolean)o ? "1" : "0";
        }
        else if (o instanceof Value)
        {
            string = ((Value)o).stringify();
        }
        else
        {
            string = String.valueOf(o);
        }

        return encodeString(string);
    }

    public static String encodeString(String in)
    {
        StringBuilder out = new StringBuilder();

        for (char c : in.toCharArray())
        {
            Character replacement = encodeMap.get(c);
            if (replacement != null)
            {
                out.append(ESCAPE_CHAR).append(replacement);
            }
            else
            {
                out.append(c);
            }
        }

        return out.toString();
    }

    /**
     * Convert escaped characters to normal characters.
     *
     * @param in The String which should be unescaped.
     *
     * @return The unescaped String
     */
    public static String decodeString(String in)
    {
        StringBuilder out = new StringBuilder();

        final int len = in.length();
        for (int i = 0; i < len; ++i)
        {
            char c = in.charAt(i);
            if (c == ESCAPE_CHAR && i + 1 < len)
            {
                char n = in.charAt(++i);
                Character replacement = decodeMap.get(n);
                if (replacement != null)
                {
                    out.append(replacement);
                }
                else
                {
                    out.append(c).append(n);
                }
            }
            else
            {
                out.append(c);
            }
        }

        return out.toString();
    }

    public static String explode(LinkedList<String> lines)
    {
        StringBuilder sb = new StringBuilder();
        String separator = "";
        for (String line : lines)
        {
            sb.append(separator).append(line);
            separator = "\n";
        }
        return sb.toString();
    }
}

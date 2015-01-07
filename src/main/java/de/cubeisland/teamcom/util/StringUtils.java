package de.cubeisland.teamcom.util;

import de.cubeisland.teamcom.query.Value;

import java.util.HashMap;
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
        if (o instanceof Value)
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
}

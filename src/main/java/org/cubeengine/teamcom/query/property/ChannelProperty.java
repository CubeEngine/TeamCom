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
package org.cubeengine.teamcom.query.property;

import org.cubeengine.teamcom.query.Property;

import java.util.HashSet;
import java.util.Set;

public enum ChannelProperty implements Property
{
    /**
     * Name of the channel
     */
    CHANNEL_NAME(true),
    /**
     * Topic of the channel
     */
    CHANNEL_TOPIC(true),
    /**
     * Description of the channel
     */
    CHANNEL_DESCRIPTION(true),
    /**
     * Password of the channel
     */
    CHANNEL_PASSWORD(true),
    /**
     * Indicates whether the channel has a password set or not
     */
    CHANNEL_FLAG_PASSWORD(false),
    /**
     * Codec used by the channel (see Definitions)
     */
    CHANNEL___CODEC(true),
    // TODO

    /**
     * Codec quality used by the channel
     */
    CHANNEL_CODEC_QUALITY(true),

    /**
     * Individual max number of clients for the channel
     */
    CHANNEL_MAXCLIENTS(true),

    /**
     * Individual max number of clients for the channel family
     */
    CHANNEL_MAXFAMILYCLIENTS(true),

    /**
     * ID of the channel below which the channel is positioned
     */
    CHANNEL_ORDER(true),

    /**
     * Indicates whether the channel is permanent or not
     */
    CHANNEL_FLAG_PERMANENT(true),

    /**
     * Indicates whether the channel is semi - permanent or not
     */
    CHANNEL_FLAG_SEMI_PERMANENT(true),

    /**
     * Indicates whether the channel is temporary or not
     */
    CHANNEL_FLAG_TEMPORARY(true),

    /**
     * Indicates whether the channel is the virtual servers default channel or not
     */
    CHANNEL_FLAG_DEFAULT(true),

    /**
     * Indicates whether the channel has a max clients limit or not
     */
    CHANNEL_FLAG_MAXCLIENTS_UNLIMITED(true),

    /**
     * Indicates whether the channel has a max family clients limit or not
     */
    CHANNEL_FLAG_MAXFAMILYCLIENTS_UNLIMITED(true),

    /**
     * Indicates whether the channel inherits the max family clients from his parent channel or not
     */
    CHANNEL_FLAG_MAXFAMILYCLIENTS_INHERITED(true),

    /**
     * Needed talk power for this channel
     */
    CHANNEL_NEEDED_TALK_POWER(true),

    /**
     * Phonetic name of the channel
     */
    CHANNEL_NAME_PHONETIC(true),

    /**
     * Path of the channels file repository
     */
    CHANNEL_FILEPATH(false),

    /**
     * Indicates whether the channel is silenced or not
     */
    CHANNEL_FORCED_SILENCE(false),

    /**
     * CRC32 checksum of the channel icon
     */
    CHANNEL_ICON_ID(true),

    /**
     * Indicates whether speech data transmitted in this channel is encrypted or not
     */
    CHANNEL_CODEC_IS_UNENCRYPTED(true),

    /**
     * The channels parent ID
     */
    CPID(true),

    /**
     * The channels ID
     */
    CID(false);

    public static final Set<Property> CHANNEL_EDIT = new HashSet<Property>();
    public static final Set<Property> CHANNEL_READ = new HashSet<Property>();

    static
    {
        for (ChannelProperty property : values())
        {
            if (property.editable)
            {
                CHANNEL_EDIT.add(property);
            }
            CHANNEL_READ.add(property);
        }
    }


    private boolean editable;


    ChannelProperty(boolean editable)
    {
        this.editable = editable;
    }

    public boolean accepts(Object value)
    {
        return true;
    }

    public String getName()
    {
        return this.name().toLowerCase();
    }
}

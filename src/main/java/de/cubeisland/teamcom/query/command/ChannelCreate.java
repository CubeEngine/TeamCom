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

import de.cubeisland.teamcom.query.property.ChannelProperty;
import de.cubeisland.teamcom.query.Command;

/**
 * Creates a new channel using the given properties and displays its ID.
 * <br>Note that this command accepts multiple properties which means that you're able to specify all settings of the new channel at once.
 * <br><br>
 * Syntax:
 * <br>channelcreate channel_name={channelName} [channel_properties…]
 */
public class ChannelCreate extends Command
{
    public ChannelCreate name(String name)
    {
        this.setParam("name", name);
        return this;
    }

    public ChannelCreate property(ChannelProperty property, Object value)
    {
        this.setProperty(property, value);
        return this;
    }
    //Permissions:"i_channel_min_depth i_channel_max_depth b_channel_create_child b_channel_create_permanent b_channel_create_semi_permanent b_channel_create_temporary b_channel_create_with_topic b_channel_create_with_description b_channel_create_with_password b_channel_create_modify_with_codec_speex8 b_channel_create_modify_with_codec_speex16 b_channel_create_modify_with_codec_speex32 b_channel_create_modify_with_codec_celtmono48 i_channel_create_modify_with_codec_maxquality i_channel_create_modify_with_codec_latency_factor_min b_channel_create_with_maxclients b_channel_create_with_maxfamilyclients b_channel_create_with_sortorder b_channel_create_with_default b_channel_create_with_needed_talk_power"
}

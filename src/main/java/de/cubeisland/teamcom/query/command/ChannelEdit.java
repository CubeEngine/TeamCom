package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.property.ChannelProperty;
import de.cubeisland.teamcom.query.Command;

/**
 * Changes a channels configuration using given properties.
 * <br>Note that this command accepts multiple properties which means that you're able to change all settings of the channel specified with cid at once.
 * <br>For detailed information, see Channel Properties.
 * <br><br>
 * Syntax:
 * <br>channeledit cid={channelID} [channel_properties…]
 */
public class ChannelEdit extends Command
{
    public ChannelEdit name(String name)
    {
        this.setParam("name", name);
        return this;
    }

    public ChannelEdit property(ChannelProperty property, Object value)
    {
        this.setProperty(property, value);
        return this;
    }
    //Permissions:"i_channel_min_depth i_channel_max_depth b_channel_modify_parent b_channel_modify_make_default b_channel_modify_make_permanent b_channel_modify_make_semi_permanent b_channel_modify_make_temporary b_channel_modify_name b_channel_modify_topic b_channel_modify_description b_channel_modify_password b_channel_modify_codec b_channel_create_modify_with_codec_speex8 b_channel_create_modify_with_codec_speex16 b_channel_create_modify_with_codec_speex32 b_channel_create_modify_with_codec_celtmono48 b_channel_modify_codec_quality b_channel_create_modify_with_codec_maxquality b_cha nnel_modify_codec_latency_factor b_channel_modify_make_codec_encrypted b_channel_modify_maxclients b_channel_modify_maxfamilyclients b_channel_modify_sortorder b_channel_modify_needed_talk_power i_channel_modify_power i_channel_needed_modify_power"
}

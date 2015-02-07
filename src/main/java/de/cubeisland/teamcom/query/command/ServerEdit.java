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
 * Changes the selected virtual servers configuration using given properties.
 * <br>Note that this command accepts multiple properties which means that you're able to change all settings of the selected virtual server at once.
 * <br>For detailed information, see Virtual Server Properties.
 * <br><br>
 * Syntax:
 * <br>serveredit [virtualserver_properties…]
 */
public class ServerEdit extends Command
{
    public ServerEdit property(VirtualServerProperty property, Object value)
    {
        this.setProperty(property, value);
        return this;
    }
    //Permissions:"b_virtualserver_modify_name", "b_virtualserver_modify_welcomemessage", "b_virtualserver_modify_maxclients", "b_virtualserver_modify_reserved_slots", "b_virtualserver_modify_password", "b_virtualserver_modify_default_servergroup", "b_virtualserver_modify_default_channelgroup", "b_virtualserver_modify_default_channeladmingroup", "b_virtualserver_modify_ft_settings", "b_virtualserver_modify_ft_quotas", "b_virtualserver_modify_channel_forced_silence", "b_virtualserver_modify_complain", "b_virtualserver_modify_antiflood", "b_virtualserver_modify_hostmessage", "b_virtualserver_modify_hostbanner", "b_virtualserver_modify_hostbutton", "b_virtualserver_modify_port", "b_virtualserver_modify_autostart", "b_virtualserver_modify_needed_identity_security_level", "b_virtualserver_modify_priority_speaker_dimm_modificator", "b_virtualserver_modify_log_settings", "b_virtualserver_modify_icon_id", "b_virtualserver_modify_weblist", "b_virtualserver_modify_min_client_version", "b_virtualserver_modify_codec_encryption_mode"
}

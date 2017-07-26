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
package org.cubeengine.teamcom.query;

import java.util.Map;

/**
 * Implement this interface, if you want to receive notify events from Teamspeak 3 server.
 *
 * @author Stefan Martens
 * @see QueryConnection#setListener(ActionListener)
 * @see QueryConnection#removeListener()
 */
public interface ActionListener
{
    /**
     * This function will be called, if the Teamspeak server sends an event notify.<br><br>
     * Following event types can occur:<br>
     * <code>notifycliententerview</code> - Client join server<br>
     * <code>notifyclientleftview</code> - Client left server<br>
     * <code>notifytextmessage</code> - Chat message received or sent<br>
     * <code>notifyclientmoved</code> - Client was moved or switched channel
     *
     * @param eventType The type of the event, for a small list, see above.
     * @param eventInfo A HashMap which contains all keys of the event
     */
    void listen(String eventType, Map<String, String> eventInfo);
}

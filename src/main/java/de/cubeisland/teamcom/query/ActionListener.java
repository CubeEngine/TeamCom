package de.cubeisland.teamcom.query;

import java.util.Map;

/**
 * Implement this interface, if you want to receive notify events from Teamspeak 3 server.
 *
 * @author Stefan Martens
 * @see QueryConnection#setListener(ActionListener)
 * @see QueryConnection#removeListener()
 * @since 0.7
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

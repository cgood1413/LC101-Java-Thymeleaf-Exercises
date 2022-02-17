package org.launchcode.codingevents.data;

import org.launchcode.codingevents.models.Event;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class EventData {

    private static final Map<Integer, Event> events = new HashMap<>();

    public static void addEvent(Event newEvent){
        events.put(newEvent.getId(), newEvent);
    }

    public static void removeEvent(int id){
       if (events.containsKey(id)) {
            events.remove(id);
        }
    }

    public static Event getById(int id){
        return events.get(id);
    }

    public static Collection<Event> getAllEvents(){
        return events.values();
    }
}

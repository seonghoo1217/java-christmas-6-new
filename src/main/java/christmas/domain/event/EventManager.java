package christmas.domain.event;

import java.util.LinkedList;
import java.util.List;

public class EventManager {
    private final LinkedList<Event> events = new LinkedList<>();

    public EventManager() {
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    public void addEventDetails(List<Event> eventsDetail) {
        events.addAll(eventsDetail);
    }

    public LinkedList<Event> getEvents() {
        return events;
    }

    public boolean orderIsNotPromotionTarget() {
        return this.events.isEmpty();
    }
}

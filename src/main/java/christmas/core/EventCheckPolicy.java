package christmas.core;

import static christmas.core.property.PolicyProperty.AMOUNT_STANDARD;
import static christmas.core.property.PolicyProperty.EVENT_STANDARD;

public class EventCheckPolicy implements EventPolicy {
    @Override
    public boolean orderIsEventTarget(Integer totalAmount) {
        return totalAmount >= EVENT_STANDARD;
    }

    @Override
    public boolean giveAwayEvent(Integer totalAmount) {
        return totalAmount >= AMOUNT_STANDARD;
    }
}

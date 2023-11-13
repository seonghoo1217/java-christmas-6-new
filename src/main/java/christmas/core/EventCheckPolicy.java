package christmas.core;

import static christmas.core.property.PolicyProperty.AMOUNT_STANDARD;

public class EventCheckPolicy implements EventPolicy {
    @Override
    public boolean giveAwayEvent(Integer totalAmount) {
        return totalAmount >= AMOUNT_STANDARD;
    }
}

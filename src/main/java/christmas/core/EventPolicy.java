package christmas.core;

public interface EventPolicy {
    boolean orderIsEventTarget(Integer totalAmount);

    boolean giveAwayEvent(Integer totalAmount);
}

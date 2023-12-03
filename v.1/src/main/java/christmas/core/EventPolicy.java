package christmas.core;

import christmas.domain.calender.Calendar;

public interface EventPolicy {
    boolean orderIsEventTarget(Integer totalAmount);

    boolean giveAwayEvent(Integer totalAmount);

    Integer christmasDDayPromotion(Calendar calendar);

    boolean dateIsWeekDay(Calendar calendar);

    Integer dateIsSpecialPromotionTarget(Calendar calendar);
}

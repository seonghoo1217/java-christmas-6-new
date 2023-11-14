package christmas.core;

import christmas.domain.calender.Calendar;
import christmas.domain.calender.SpecialPromotion;

import java.time.DayOfWeek;
import java.util.EnumSet;

import static christmas.core.property.PolicyProperty.*;
import static java.time.DayOfWeek.*;

public class EventCheckPolicy implements EventPolicy {
    @Override
    public boolean orderIsEventTarget(Integer totalAmount) {
        return totalAmount >= EVENT_STANDARD;
    }

    @Override
    public boolean giveAwayEvent(Integer totalAmount) {
        return totalAmount >= AMOUNT_STANDARD;
    }

    @Override
    public Integer christmasDDayPromotion(Calendar calendar) {
        Integer date = calendar.getDate();
        if (date > D_DAY_STANDARD) return 0;
        System.out.println(((date - 1) * 100) + 1000);
        return ((date - 1) * 100) + 1000;
    }

    @Override
    public boolean dateIsWeekDay(Calendar calendar) {
        DayOfWeek dayOfWeek = calendar.getDayOfWeek();
        return EnumSet.of(SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY).contains(dayOfWeek);
    }

    @Override
    public Integer dateIsSpecialPromotionTarget(Calendar calendar) {
        if (calendar.getSpecialPromotion().equals(SpecialPromotion.TARGET)) {
            return 1000;
        }
        return 0;
    }
}

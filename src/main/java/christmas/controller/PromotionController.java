package christmas.controller;

import christmas.core.EventPolicy;
import christmas.domain.calender.Calendar;
import christmas.domain.event.Event;
import christmas.domain.menu.MenuType;
import christmas.domain.menu.RestaurantManager;

import static christmas.domain.event.property.PromotionProperty.*;

public class PromotionController {

    private final EventPolicy eventPolicy;

    public PromotionController(EventPolicy eventPolicy) {
        this.eventPolicy = eventPolicy;
    }

    public Event dDayPromotion(Calendar calendar) {
        Integer promotionPrice = eventPolicy.christmasDDayPromotion(calendar);
        if (promotionPrice == 0) {
            return new Event(NO_PROMOTION_PRICE, NO_PROMOTION_CONTENTS);
        }
        return new Event(promotionPrice, D_DAY_PROMOTION_CONTENTS);
    }

    public Event weekOrWeekendPromotion(Calendar calendar, RestaurantManager restaurantManager) {
        if (eventPolicy.dateIsWeekDay(calendar)) {
            return new Event(restaurantManager.promotionDiscountWeekOfDay(
                    MenuType.DESSERT, WEEK_OR_WEEKEND_PROMOTION_PRICE),
                    WEEKDAY_PROMOTION_CONTENTS
            );
        }
        return new Event(restaurantManager.promotionDiscountWeekOfDay(
                MenuType.MAIN_DISH, WEEK_OR_WEEKEND_PROMOTION_PRICE),
                WEEKEND_PROMOTION_CONTENTS
        );
    }

    public Event specialPromotion(Calendar calendar) {
        Integer promotionPrice = eventPolicy.dateIsSpecialPromotionTarget(calendar);
        if (promotionPrice == 0) {
            return new Event(NO_PROMOTION_PRICE, NO_PROMOTION_CONTENTS);
        }
        return new Event(promotionPrice, SPECIAL_PROMOTION_CONTENTS);
    }

    public Event presentPromotion(Integer totalAmount) {
        if (eventPolicy.giveAwayEvent(totalAmount)) {
            return new Event(PRESENTATION_PRICE, PRESENTATION_DETAIL_CONTENTS);
        }
        return new Event(NO_PROMOTION_PRICE, NO_PROMOTION_CONTENTS);
    }
}

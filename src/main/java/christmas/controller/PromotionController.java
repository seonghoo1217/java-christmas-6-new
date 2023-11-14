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
            return notPromotion();
        }
        return new Event(promotionPrice, D_DAY_PROMOTION_CONTENTS);
    }

    public Event weekOrWeekendPromotion(Calendar calendar, RestaurantManager restaurantManager) {
        return generaeWeekEvent(restaurantManager, menuTypeByDateIsWeekDay(calendar), contentsByDateIsWeekDay(calendar));
    }

    private Event generaeWeekEvent(RestaurantManager restaurantManager, MenuType menuType, String contents) {
        Integer promotionPrice = restaurantManager.promotionDiscountWeekOfDay(menuType, WEEK_OR_WEEKEND_PROMOTION_PRICE);
        if (promotionPrice == 0) return notPromotion();
        return new Event(promotionPrice, contents);
    }

    private MenuType menuTypeByDateIsWeekDay(Calendar calendar) {
        if (eventPolicy.dateIsWeekDay(calendar)) {
            return MenuType.DESSERT;
        }
        return MenuType.MAIN_DISH;
    }

    private String contentsByDateIsWeekDay(Calendar calendar) {
        if (eventPolicy.dateIsWeekDay(calendar)) {
            return WEEKDAY_PROMOTION_CONTENTS;
        }
        return WEEKEND_PROMOTION_CONTENTS;
    }

    public Event specialPromotion(Calendar calendar) {
        Integer promotionPrice = eventPolicy.dateIsSpecialPromotionTarget(calendar);
        if (promotionPrice == 0) {
            return notPromotion();
        }
        return new Event(promotionPrice, SPECIAL_PROMOTION_CONTENTS);
    }

    public Event presentPromotion(Integer totalAmount) {
        if (eventPolicy.giveAwayEvent(totalAmount)) {
            return new Event(PRESENTATION_PRICE, PRESENTATION_DETAIL_CONTENTS);
        }
        return notPromotion();
    }

    public Event notPromotion() {
        return new Event(NO_PROMOTION_PRICE, NO_PROMOTION_CONTENTS);
    }
}

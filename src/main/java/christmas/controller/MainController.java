package christmas.controller;

import christmas.core.EventPolicy;
import christmas.domain.calender.Calendar;
import christmas.domain.event.Event;
import christmas.domain.event.EventManager;
import christmas.domain.menu.MenuType;
import christmas.domain.menu.RestaurantManager;
import christmas.tool.EventDetailGenerateTool;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static christmas.domain.event.property.PromotionProperty.*;

public class MainController {

    private final InputView inputView;
    private final OutputView outputView;
    private final EventPolicy eventPolicy;

    public MainController(InputView inputView, OutputView outputView, EventPolicy eventPolicy) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.eventPolicy = eventPolicy;
    }

    public void restaurantOpening() {
        Calendar calendar = inputView.readVisitDate();
        RestaurantManager restaurantManager = inputView.readOrderMenu();
        outputView.outputForEventNotice();
        outputView.outputForOrderMenus(restaurantManager.getOrder().orderStatus());
        outputView.outputForTotalAmount(restaurantManager.getOrder().totalAmount());
        orderIsPromotionTarget(calendar, restaurantManager);
    }

    private void orderIsPromotionTarget(Calendar calendar, RestaurantManager restaurantManager) {
        EventDetailGenerateTool eventDetailGenerateTool = new EventDetailGenerateTool();
        if (eventPolicy.orderIsEventTarget(restaurantManager.getOrder().totalAmount())) {
            EventManager eventManager = promotionProgress(calendar, restaurantManager);
            String s = eventDetailGenerateTool.eventResultGenerate(eventManager, restaurantManager.getOrder().totalAmount());
            System.out.println(s);
        }
    }

    private EventManager promotionProgress(Calendar calendar, RestaurantManager restaurantManager) {
        EventManager eventManager = new EventManager();
        Integer totalAmount = restaurantManager.getOrder().totalAmount();
        if (promotionByPresentation(totalAmount)) {
            eventManager.addEvent(new Event(PRESENTATION_PRICE, PRESENTATION_CONTENTS));
        }
        eventManager.addEventDetails(promotionDetails(calendar, totalAmount, restaurantManager));
        return eventManager;
    }

    private boolean promotionByPresentation(Integer totalAmount) {
        return eventPolicy.giveAwayEvent(totalAmount);
    }

    private List<Event> promotionDetails(Calendar calendar, Integer totalAmount, RestaurantManager restaurantManager) {
        List<Event> promotionDetails = new ArrayList<>();
        promotionDetails.add(new Event(eventPolicy.christmasDDayPromotion(calendar), D_DAY_PROMOTION_CONTENTS));
        promotionDetails.add(weekOrWeekendPromotion(calendar, restaurantManager));
        promotionDetails.add(new Event(eventPolicy.dateIsSpecialPromotionTarget(calendar), SPECIAL_PROMOTION_CONTENTS));
        promotionDetails.add(orderCostIsOverPresentation(totalAmount));
        return promotionDetails;
    }

    private Event orderCostIsOverPresentation(Integer totalAmount) {
        if (promotionByPresentation(totalAmount)) {
            return new Event(PRESENTATION_PRICE, PRESENTATION_DETAIL_CONTENTS);
        }
        return new Event(NO_PROMOTION_PRICE, NO_PROMOTION_CONTENTS);
    }

    private Event weekOrWeekendPromotion(Calendar calendar, RestaurantManager restaurantManager) {
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

    private void promotionDetails(EventManager eventManager) {
        outputView.outputForPromotion(eventManager);
    }
}

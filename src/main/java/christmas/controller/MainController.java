package christmas.controller;

import christmas.core.EventPolicy;
import christmas.domain.calender.Calendar;
import christmas.domain.event.Event;
import christmas.domain.event.EventManager;
import christmas.domain.menu.RestaurantManager;
import christmas.view.InputView;
import christmas.view.OutputView;

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
    }

    private void orderIsPromotionTarget(Calendar calendar, RestaurantManager restaurantManager) {
        if (eventPolicy.orderIsEventTarget(restaurantManager.getOrder().totalAmount())) {
            promotionProgress(calendar, restaurantManager);
        }
    }

    private void promotionProgress(Calendar calendar, RestaurantManager restaurantManager) {
        EventManager eventManager = new EventManager();
        eventManager.addEvent(promotionByPresentation(restaurantManager.getOrder().totalAmount()));
    }

    private Event promotionByPresentation(Integer totalAmount) {
        if (eventPolicy.giveAwayEvent(totalAmount)) {
            return new Event(PRESENTATION_PRICE, PRESENTATION_CONTENTS);
        }
        return new Event(NO_PROMOTION_PRICE, NO_PROMOTION_CONTENTS);
    }
}

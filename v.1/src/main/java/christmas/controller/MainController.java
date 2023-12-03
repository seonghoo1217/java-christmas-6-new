package christmas.controller;

import christmas.core.EventPolicy;
import christmas.domain.calender.Calendar;
import christmas.domain.event.Event;
import christmas.domain.event.EventManager;
import christmas.domain.menu.RestaurantManager;
import christmas.tool.EventDetailGenerateTool;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static christmas.domain.event.property.PromotionProperty.*;
import static christmas.view.property.OutputProperty.EVENT_NOTICE;

public class MainController {

    private final InputView inputView;
    private final OutputView outputView;
    private final EventPolicy eventPolicy;
    private final PromotionController promotionController;

    public MainController(InputView inputView, OutputView outputView, EventPolicy eventPolicy) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.eventPolicy = eventPolicy;
        this.promotionController = new PromotionController(eventPolicy);
    }

    public void restaurantOpening() {
        Calendar calendar = inputView.readVisitDate();
        RestaurantManager restaurantManager = inputView.readOrderMenu();
        restaurantManager.addOrder();
        orderReceivedByManager(calendar, restaurantManager);
    }

    private void orderReceivedByManager(Calendar calendar, RestaurantManager restaurantManager) {
        outputView.outputForEventNotice(EVENT_NOTICE.formatted(calendar.getDate()));
        outputView.outputForOrderMenus(restaurantManager.getOrder().orderStatus());
        outputView.outputForTotalAmount(restaurantManager.getOrder().totalAmount());
        orderIsPromotionTarget(calendar, restaurantManager);
    }

    private void orderIsPromotionTarget(Calendar calendar, RestaurantManager restaurantManager) {
        EventDetailGenerateTool eventDetailGenerateTool = new EventDetailGenerateTool();
        EventManager eventManager = promotionStop();

        if (eventPolicy.orderIsEventTarget(restaurantManager.getOrder().totalAmount())) {
            eventManager = promotionProgress(calendar, restaurantManager);
        }
        String eventResult = eventDetailGenerateTool.eventResultGenerate(eventManager, restaurantManager.getOrder().totalAmount());
        outputView.outputForEventResult(eventResult);
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
        promotionDetails.add(promotionController.dDayPromotion(calendar));
        promotionDetails.add(promotionController.weekOrWeekendPromotion(calendar, restaurantManager));
        promotionDetails.add(promotionController.specialPromotion(calendar));
        promotionDetails.add(promotionController.presentPromotion(totalAmount));
        return promotionDetails;
    }

    private EventManager promotionStop() {
        EventManager eventManager = new EventManager();
        eventManager.addEvent(new Event(NO_PROMOTION_PRICE, NO_PROMOTION_CONTENTS));
        return eventManager;
    }
}

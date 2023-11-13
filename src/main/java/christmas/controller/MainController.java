package christmas.controller;

import christmas.core.EventPolicy;
import christmas.domain.calender.Calendar;
import christmas.domain.menu.RestaurantManager;
import christmas.view.InputView;
import christmas.view.OutputView;

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
}

package christmas.controller;

import christmas.domain.calender.Calendar;
import christmas.domain.menu.RestaurantManager;
import christmas.view.InputView;
import christmas.view.OutputView;

public class MainController {

    private final InputView inputView;
    private final OutputView outputView;

    public MainController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void restaurantOpening() {
        Calendar calendar = inputView.readVisitDate();
        RestaurantManager restaurantManager = inputView.readOrderMenu();
        outputView.outputForEventNotice();
        outputView.outputForOrderMenus(restaurantManager.getOrder().orderStatus());
        outputView.outputForTotalAmount(restaurantManager.getOrder().totalAmount());
    }
}

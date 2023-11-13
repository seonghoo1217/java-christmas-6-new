package christmas.controller;

import christmas.core.EventCheckPolicy;
import christmas.core.EventPolicy;
import christmas.view.InputView;
import christmas.view.OutputView;

public class Application {
    public static void main(String[] args) {
        MainController mainController = new MainController(inputView(), outputView(), eventPolicy());
        mainController.restaurantOpening();
    }

    private static InputView inputView() {
        return new InputView();
    }

    private static OutputView outputView() {
        return new OutputView();
    }

    private static EventPolicy eventPolicy() {
        return new EventCheckPolicy();
    }
}

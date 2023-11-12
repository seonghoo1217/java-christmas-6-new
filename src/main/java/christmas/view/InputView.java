package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.calender.Calendar;
import christmas.domain.menu.RestaurantManager;

import static christmas.view.property.InputProperty.*;

public class InputView {

    public Calendar readVisitDate() {
        System.out.println(RESTAURANT_OPEN);
        try {
            return new Calendar(Console.readLine(), YEAR, MONTH);
        } catch (IllegalArgumentException e) {
            OutputView.outputForInputErrorMessage(e);
            return readVisitDate();
        }
    }

    public RestaurantManager readOrderMenu() {
        System.out.println(ORDER_MENUS);
        try {
            return new RestaurantManager(Console.readLine());
        } catch (IllegalArgumentException e) {
            OutputView.outputForInputErrorMessage(e);
            return readOrderMenu();
        }
    }
}

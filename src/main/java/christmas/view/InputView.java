package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.calender.Calendar;

import static christmas.view.property.InputProperty.*;

public class InputView {

    public static Calendar readVisitDate() {
        System.out.println(RESTAURANT_OPEN);
        try {
            return new Calendar(Console.readLine(), YEAR, MONTH);
        } catch (IllegalArgumentException e) {
            OutputView.outputForInputErrorMessage(e);
            return readVisitDate();
        }
    }
}

package christmas.contoller;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.date.PickDate;
import christmas.validation.DateValidation;

public class InputController {

    private final DateValidation dateValidation;

    public InputController(DateValidation dateValidation) {
        this.dateValidation = dateValidation;
    }

    public PickDate inputPickDate(){
        try {
            String pickDate = Console.readLine();
            return new PickDate(pickDate, dateValidation);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return inputPickDate();
        }
    }
}

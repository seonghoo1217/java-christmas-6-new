package christmas.contoller;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.date.PickDate;

public class InputController {

    public PickDate inputPickDate(){
        try {
            String pickDate = Console.readLine();
            return new PickDate(pickDate);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return inputPickDate();
        }
    }
}

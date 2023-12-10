package christmas.validation;

import christmas.domain.date.PickDate;

import java.math.BigInteger;

public class DateValidation {

    public void isValidate(String date){
        isNotNumeric(date);
        isNotCorrectlyDate(date);
    }

    private void isNotNumeric(String date) {
        if (!date.equals("?\\d+")) {
            throw new IllegalArgumentException(ErrorCode.INVALID_DATE_EXCEPTION.message);
        }
    }

    private void isNotCorrectlyDate(String date){
        try {
            int dateInteger = Integer.parseInt(date);
            if (!dateIsCalendarFormCorrect(dateInteger)){
                throw new IllegalArgumentException(ErrorCode.INVALID_DATE_EXCEPTION.message);
            }
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(ErrorCode.INVALID_DATE_EXCEPTION.message);
        }
    }

    private boolean dateIsCalendarFormCorrect(Integer dateInteger){
        return dateInteger > 0 && dateInteger < 32;
    }
}

package christmas.validation;

import christmas.domain.date.PickDate;

public class DateValidation {

    public void isValidate(String date){
        isNotNumeric(date);
    }

    private void isNotNumeric(String date){
        if (!date.equals("-?\\d+")) {
            throw new IllegalArgumentException(ErrorCode.INVALID_DATE_EXCEPTION.message);
        }
    }
}

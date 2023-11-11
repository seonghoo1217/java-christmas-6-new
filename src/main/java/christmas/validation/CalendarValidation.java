package christmas.validation;

import static christmas.property.ErrorProperty.ERROR_INVALIDATE_DATE_NOT_NUMERIC;
import static christmas.property.ErrorProperty.ERROR_INVALIDATE_DATE_RANGE;
import static christmas.validation.property.ValidationProperty.DATE_END;
import static christmas.validation.property.ValidationProperty.DATE_START;

public class CalendarValidation {

    public void verifyForCalendarCorrectRange(String inputDate) {
        try {
            int date = Integer.parseInt(inputDate);
            if (date < DATE_START || date > DATE_END) {
                throw new IllegalArgumentException(ERROR_INVALIDATE_DATE_RANGE);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_INVALIDATE_DATE_NOT_NUMERIC);
        }
    }
}

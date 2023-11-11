package christmas.domain.calender;

import christmas.validation.CalendarValidation;

public class Calendar {
    private Integer date;

    public Calendar(String inputDate) {
        this.date = parsingDateFormat(inputDate);
    }

    private Integer parsingDateFormat(String inputDate) {
        validate(inputDate);
        return Integer.parseInt(inputDate);
    }

    private void validate(String inputDate) {
        CalendarValidation calendarValidation = new CalendarValidation();
        calendarValidation.verifyForCalendarCorrectRange(inputDate);
    }
}

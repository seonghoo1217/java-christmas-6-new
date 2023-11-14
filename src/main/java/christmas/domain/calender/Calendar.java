package christmas.domain.calender;

import christmas.validation.CalendarValidation;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Calendar {
    private Integer date;
    private DayOfWeek dayOfWeek;

    private SpecialPromotion specialPromotion;

    public Calendar(String inputDate, int year, int month) {
        this.date = parsingDateFormat(inputDate);
        this.dayOfWeek = caclulateDayOfWeek(year, month, this.date);
        this.specialPromotion = pickDateIsSpecialPromotionTarget();
    }

    private Integer parsingDateFormat(String inputDate) {
        validate(inputDate);
        return Integer.parseInt(inputDate);
    }

    private void validate(String inputDate) {
        CalendarValidation calendarValidation = new CalendarValidation();
        calendarValidation.verifyForCalendarCorrectRange(inputDate);
    }

    private DayOfWeek caclulateDayOfWeek(int year, int month, int day) {
        return LocalDate.of(year, month, day).getDayOfWeek();
    }

    private SpecialPromotion pickDateIsSpecialPromotionTarget() {
        if (this.dayOfWeek == DayOfWeek.SUNDAY) {
            return SpecialPromotion.TARGET;
        }
        if (this.date == 25) {
            return SpecialPromotion.TARGET;
        }
        return SpecialPromotion.NONE;
    }

    public Integer getDate() {
        return date;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public SpecialPromotion getSpecialPromotion() {
        return specialPromotion;
    }
}

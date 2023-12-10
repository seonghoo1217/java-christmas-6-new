package christmas.domain.date;

import christmas.validation.DateValidation;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static christmas.domain.date.DateProperty.*;

public record PickDate(String date, DateValidation dateValidation) {
    private static DayOfWeek dayOfWeek;

    public void pickDayOfWeek(){
        dayOfWeek = LocalDate.of(YEAR, MONTH, Integer.parseInt(date)).getDayOfWeek();
    }
    public PickDate{
        dateValidation.isValidate(date);
    }
}

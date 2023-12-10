package christmas.domain.date;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static christmas.domain.date.DateProperty.*;

public record PickDate(String date) {
    private static DayOfWeek dayOfWeek;

    public void pickDayOfWeek(){
        dayOfWeek = LocalDate.of(YEAR, MONTH, Integer.parseInt(date)).getDayOfWeek();
    }
    public PickDate{

    }
}

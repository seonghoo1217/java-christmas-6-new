package christmas.domain;

import christmas.domain.calender.Calendar;
import christmas.domain.calender.SpecialPromotion;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.DayOfWeek;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CalendarTest {

    @ParameterizedTest
    @MethodSource("correctDateInput")
    void Calendar_객체_생성_시_특별이벤트_대상_판별(String inputDate, int year, int month) {
        //when
        Calendar calendar = new Calendar(inputDate, year, month);

        //then
        assertThat(calendar.isSpecialPromotion(calendar)).isEqualTo(SpecialPromotion.TARGET);
    }

    @ParameterizedTest
    @MethodSource("correctDateInput")
    void Calendar_객체_생성_시_요일_반환(String inputDate, int year, int month) {
        //when
        Calendar calendar = new Calendar(inputDate, year, month);

        //then
        assertThat(calendar.getDayOfWeek()).isEqualTo(DayOfWeek.SUNDAY);
    }

    static Stream<Arguments> correctDateInput() {
        return Stream.of(
                Arguments.arguments("24", 2023, 12),
                Arguments.arguments("17", 2023, 12)
        );
    }
}

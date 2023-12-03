package christmas.validation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalendarValidationTest {

    public static CalendarValidation calendarValidation;

    @BeforeEach
    public void initializeDependency() {
        calendarValidation = new CalendarValidation();
    }

    @ParameterizedTest
    @ValueSource(strings = {"32", "0", "-1", "999"})
    void 날짜_입력_값_1에서_31_사이의_값이_아닌_경우(String inputDate) {
        //when && then
        assertThatThrownBy(() -> {
                    calendarValidation.verifyForCalendarCorrectRange(inputDate);
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 날짜_입력_값_숫자_외의_값_입력시() {
        //given
        String inputDate = "이십오일";

        //when && then
        assertThatThrownBy(() -> {
                    calendarValidation.verifyForCalendarCorrectRange(inputDate);
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }
}

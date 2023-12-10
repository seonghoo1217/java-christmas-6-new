package christmas.validation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.*;

public class DateValidationTest {

    private DateValidation dateValidation;

    @BeforeEach
    public void initializeDependency(){
        dateValidation = new DateValidation();
    }

    @ParameterizedTest
    @ValueSource(strings = {"12.1","한글","eng"})
    public void 숫자_이외의_값이_날짜로_입력된_경우_테스트(String date){
        //when & then
        assertThatThrownBy(()->{
            dateValidation.isValidate(date);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1000","12121212121212121"})
    public void 숫자_범위_벗어난_경우_테스트(String date){
        assertThatThrownBy(()->{
            dateValidation.isValidate(date);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}

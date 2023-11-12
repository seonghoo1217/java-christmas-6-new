package christmas.validation;

import christmas.property.ErrorProperty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MenuValidationTest {

    public static MenuValidation menuValidation;

    @BeforeEach
    public void initializeDependency() {
        menuValidation = new MenuValidation();
    }

    @ParameterizedTest
    @ValueSource(strings = {"초코케이크-1,해산물파스타-1,", "초코케이크1,해산물파스타-1", "초코케이크-1해산물파스타1"})
    void 메뉴_주문_입력_시_옳바르지_못한_양식_입력한_경우(String targetOrder) {
        //when
        assertThatThrownBy(() -> {
                    menuValidation.verifyForMenus(targetOrder);
                }
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorProperty.ERROR_ORDER_NOT_CORRECT_FORMAT);
    }
}

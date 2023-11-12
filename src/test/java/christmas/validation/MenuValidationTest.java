package christmas.validation;

import christmas.property.ErrorProperty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MenuValidationTest {

    public static MenuValidation menuValidation;

    @BeforeEach
    public void initializeDependency() {
        menuValidation = new MenuValidation();
    }

    @Test
    void 메뉴_주문_입력_시_옳바르지_못한_양식_입력한_경우() {
        //given
        String targetOrder = "케이크-1,오레오,";

        //when
        assertThatThrownBy(() -> {
                    menuValidation.verifyForMenus(targetOrder);
                }
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorProperty.ERROR_ORDER_NOT_CORRECT_FORMAT);
    }
}

package christmas.validation;

import christmas.domain.menu.RestaurantManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
        //when && then
        assertThatThrownBy(() -> {
                    new RestaurantManager(targetOrder);
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 메뉴_주문_입력_시_중복된_메뉴_입력한_경우() {
        //given
        String targetOrder = "해산물파스타-1,초코케이크-1,해산물파스타-1";
        //when && then
        assertThatThrownBy(() -> {
                    new RestaurantManager(targetOrder);
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 메뉴_주문_입력_시_개수_초과_주문한_경우() {
        //given
        String targetOrder = "해산물파스타-99";
        //when & then
        assertThatThrownBy(() -> {
                    new RestaurantManager(targetOrder);
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 메뉴_주문_입력_시_개수_부족하게_주문한_경우() {
        //given
        String targetOrder = "해산물파스타-0";
        //when & then
        assertThatThrownBy(() -> {
                    new RestaurantManager(targetOrder);
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 메뉴_주문_입력_시_존재하지_않는_메뉴_주문한_경우() {
        //given
        String targetOrder = "해산물파스타-1,우아한테크코스-2";

        //when & then
        assertThatThrownBy(() -> {
                    new RestaurantManager(targetOrder);
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"제로콜라-1,레드와인-1", "레드와인-1", "제로콜라-1,샴페인-1"})
    void 메뉴_주문_입력_시_음료수만_주문한_경우(String targetOrder) {
        //when & then
        assertThatThrownBy(() -> {
                    new RestaurantManager(targetOrder);
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }
}

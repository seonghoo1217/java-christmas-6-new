package christmas.domain;

import christmas.domain.menu.MenuType;
import christmas.domain.menu.RestaurantManager;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MenuTest {

    @Test
    void Menu_생성_후_평일_또는_주말_일경우_할인() {
        //given
        String orderMenus = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";

        RestaurantManager restaurantManager = new RestaurantManager(orderMenus);
        restaurantManager.addOrder();
        Integer discount = restaurantManager.promotionDiscountWeekOfDay(MenuType.MAIN_DISH, 2023);

        assertThat(discount).isEqualTo(4046);
    }
}

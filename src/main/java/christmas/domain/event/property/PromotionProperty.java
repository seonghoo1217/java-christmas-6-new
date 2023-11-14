package christmas.domain.event.property;

import christmas.domain.menu.property.MenuProperty;

public class PromotionProperty {
    public static final Integer NO_PROMOTION_PRICE = 0;
    public static final String NO_PROMOTION_CONTENTS = "없음";
    public static final Integer PRESENTATION_PRICE = MenuProperty.샴페인.menuCost;
    public static final String PRESENTATION_CONTENTS = MenuProperty.샴페인.menuName + "1개";
}

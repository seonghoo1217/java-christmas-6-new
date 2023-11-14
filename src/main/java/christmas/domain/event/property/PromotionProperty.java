package christmas.domain.event.property;

import christmas.domain.menu.property.MenuProperty;

public class PromotionProperty {
    public static final Integer NO_PROMOTION_PRICE = 0;
    public static final String NO_PROMOTION_CONTENTS = "없음";
    public static final Integer PRESENTATION_PRICE = MenuProperty.샴페인.menuCost;
    public static final String PRESENTATION_CONTENTS = MenuProperty.샴페인.menuName + " 1개";
    public static final String D_DAY_PROMOTION_CONTENTS = "크리스마스 디데이 할인";
    public static final Integer WEEK_OR_WEEKEND_PROMOTION_PRICE = 2023;
    public static final String WEEKDAY_PROMOTION_CONTENTS = "평일 할인";
    public static final String WEEKEND_PROMOTION_CONTENTS = "주말 할인";
    public static final String SPECIAL_PROMOTION_CONTENTS = "특별 할인";
    public static final String PRESENTATION_DETAIL_CONTENTS = "증정 이벤트";
    public static final Integer EVENT_TYPE_COUNT = 5;
}

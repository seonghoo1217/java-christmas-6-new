package christmas.validation;

import christmas.property.ErrorProperty;

public class MenuValidation {

    public static void verifyForMenus(String menus) {
        verifyForOrderCorrectFormat(menus);
    }

    static void verifyForOrderCorrectFormat(String menus) {
        if (!menus.matches("^([가-힣a-zA-Z0-9]+-\\d+)(,[가-힣a-zA-Z0-9]+-\\d+)*$")) {
            throw new IllegalArgumentException(ErrorProperty.ERROR_ORDER_NOT_CORRECT_FORMAT);
        }
    }

}

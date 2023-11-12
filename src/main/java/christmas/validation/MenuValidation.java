package christmas.validation;

import christmas.property.ErrorProperty;

import java.util.ArrayList;
import java.util.List;

public class MenuValidation {

    public static void verifyForMenus(String menus) {
        verifyForOrderCorrectFormat(menus);
    }

    static void verifyForOrderCorrectFormat(String menus) {
        if (!menus.matches("^([가-힣a-zA-Z0-9]+-\\d+)(,[가-힣a-zA-Z0-9]+-\\d+)*$")) {
            throw new IllegalArgumentException(ErrorProperty.ERROR_ORDER_NOT_CORRECT_FORMAT);
        }
    }

    static List<String> extractMenuNames(String orderMenus) {
        List<String> menuNames = new ArrayList<>();
        String[] orderItems = orderMenus.split(",");

        for (String item : orderItems) {
            String menuName = item.split("-")[0];
            menuNames.add(menuName);
        }

        return menuNames;
    }
}

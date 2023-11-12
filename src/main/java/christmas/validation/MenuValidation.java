package christmas.validation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static christmas.property.ErrorProperty.ERROR_ORDER_IS_DUPLICATE;
import static christmas.property.ErrorProperty.ERROR_ORDER_NOT_CORRECT_FORMAT;

public class MenuValidation {

    public static void verifyForMenus(String menus) {
        verifyForOrderCorrectFormat(menus);
        verifyForOrderMenuDuplicate(menus);
    }

    static void verifyForOrderCorrectFormat(String menus) {
        if (!menus.matches("^([가-힣a-zA-Z0-9]+-\\d+)(,[가-힣a-zA-Z0-9]+-\\d+)*$")) {
            throw new IllegalArgumentException(ERROR_ORDER_NOT_CORRECT_FORMAT);
        }
    }

    static void verifyForOrderMenuDuplicate(String orderMenus) {
        List<String> menuNames = extractMenuNames(orderMenus);
        if (menuNames.size() != new HashSet<>(menuNames).size()) {
            throw new IllegalArgumentException(ERROR_ORDER_IS_DUPLICATE);
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

package christmas.validation;

import christmas.domain.menu.MenuManager;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static christmas.property.ErrorProperty.*;

public class MenuValidation {

    public static void verifyForMenus(String orderMenus) {
        verifyForOrderCorrectFormat(orderMenus);
        verifyForOrderMenuDuplicate(orderMenus);
    }

    static void verifyForOrderCorrectFormat(String orderMenus) {
        if (!orderMenus.matches("^([가-힣a-zA-Z0-9]+-\\d+)(,[가-힣a-zA-Z0-9]+-\\d+)*$")) {
            throw new IllegalArgumentException(ERROR_ORDER_NOT_CORRECT_FORMAT);
        }
    }

    static void verifyForOrderMenuDuplicate(String orderMenus) {
        List<String> menuNames = extractMenuNames(orderMenus);
        if (menuNames.size() != new HashSet<>(menuNames).size()) {
            throw new IllegalArgumentException(ERROR_ORDER_IS_DUPLICATE);
        }
        verifyForOrderMenuExist(menuNames);
    }

    static void verifyForOrderMenuExist(List<String> menuNames) {
        for (String name : menuNames) {
            if (!MenuManager.getMenus().contains(name)) {
                throw new IllegalArgumentException(ERROR_ORDER_MENU_IS_NOT_EXIST);
            }
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

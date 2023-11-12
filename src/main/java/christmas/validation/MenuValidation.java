package christmas.validation;

import christmas.domain.menu.Menu;
import christmas.domain.menu.MenuManager;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static christmas.property.ErrorProperty.*;
import static christmas.validation.property.ValidationProperty.MAX_ORDER;
import static christmas.validation.property.ValidationProperty.MIN_ORDER;

public class MenuValidation {

    public void verifyForMenus(String orderMenus) {
        verifyForOrderCorrectFormat(orderMenus);
        verifyForOrderMenuDuplicate(orderMenus);
        verifyForOrderCount(orderMenus);
    }

    private void verifyForOrderCorrectFormat(String orderMenus) {
        if (!orderMenus.matches("^([가-힣a-zA-Z0-9]+-\\d+)(,[가-힣a-zA-Z0-9]+-\\d+)*$")) {
            throw new IllegalArgumentException(ERROR_ORDER_NOT_CORRECT_FORMAT);
        }
    }

    private void verifyForOrderMenuDuplicate(String orderMenus) {
        List<String> menuNames = extractMenuNames(orderMenus);
        if (menuNames.size() != new HashSet<>(menuNames).size()) {
            throw new IllegalArgumentException(ERROR_ORDER_IS_DUPLICATE);
        }
        verifyForOrderMenuExist(menuNames);
    }

    private void verifyForOrderMenuExist(List<String> orderMenuNames) {
        if (!menuNameIsExist(orderMenuNames)) {
            throw new IllegalArgumentException(ERROR_ORDER_MENU_IS_NOT_EXIST);
        }
    }


    private void verifyForOrderCount(String orderMenus) {
        if (extractOrderCount(orderMenus)) {
            throw new IllegalArgumentException(ERROR_ORDER_COUNT);
        }
    }

    private List<String> extractMenuNames(String orderMenus) {
        List<String> menuNames = new ArrayList<>();
        String[] orderItems = orderMenus.split(",");

        for (String item : orderItems) {
            String menuName = item.split("-")[0];
            menuNames.add(menuName);
        }

        return menuNames;
    }

    private boolean extractOrderCount(String orderMenus) {
        int orderCount = 0;
        String[] orderItems = orderMenus.split(",");

        for (String item : orderItems) {
            orderCount += Integer.parseInt(item.split("-")[1]);
        }
        return orderCount < MIN_ORDER || orderCount > MAX_ORDER;
    }

    private boolean menuNameIsExist(List<String> orderMenuNames) {
        return orderMenuNames.stream().allMatch(getMenuNames()::contains);
    }

    private List<String> getMenuNames() {
        return MenuManager.getMenus().stream().map(Menu::getName).toList();
    }
}

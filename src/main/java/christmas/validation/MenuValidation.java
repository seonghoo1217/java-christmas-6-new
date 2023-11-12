package christmas.validation;

import christmas.domain.menu.Menu;
import christmas.domain.menu.MenuManager;
import christmas.domain.menu.MenuType;
import christmas.tool.MenuExtractTool;

import java.util.HashSet;
import java.util.List;

import static christmas.property.ErrorProperty.*;
import static christmas.validation.property.ValidationProperty.*;

public class MenuValidation {

    private static MenuExtractTool menuExtractTool = new MenuExtractTool();

    public void verifyForMenus(String inputOrderMenus) {
        String orderMenus = inputOrderMenus.replaceAll(DELIMITER, "");
        verifyForOrderCorrectFormat(orderMenus);
        verifyForOrderMenuDuplicate(orderMenus);
        verifyForOrderCount(orderMenus);
        verifyForOrderOnlyBeverage(orderMenus);
    }

    private void verifyForOrderCorrectFormat(String orderMenus) {
        if (!orderMenus.matches("^([가-힣a-zA-Z0-9]+-\\d+)(,[가-힣a-zA-Z0-9]+-\\d+)*$")) {
            throw new IllegalArgumentException(ERROR_ORDER_NOT_CORRECT_FORMAT);
        }
    }

    private void verifyForOrderMenuDuplicate(String orderMenus) {
        List<String> menuNames = menuExtractTool.extractMenuNames(orderMenus);
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
        int orderCount = menuExtractTool.extractOrderCount(orderMenus);
        if (orderCount < MIN_ORDER || orderCount > MAX_ORDER) {
            throw new IllegalArgumentException(ERROR_ORDER_COUNT);
        }
    }

    private void verifyForOrderOnlyBeverage(String orderMenus) {
        List<MenuType> menuTypes = menuExtractTool.extractMenuType(orderMenus);
        if (menusIsOnlyBeverage(menuTypes)) {
            throw new IllegalArgumentException(ERROR_ORDER_ONLY_BEVERAGE);
        }
    }

    private boolean menuNameIsExist(List<String> orderMenuNames) {
        return orderMenuNames.stream().allMatch(getMenuNames()::contains);
    }

    private List<String> getMenuNames() {
        return MenuManager.getMenus().stream().map(Menu::getName).toList();
    }

    private boolean menusIsOnlyBeverage(List<MenuType> menuTypes) {
        return menuTypes.stream().allMatch(menuType -> menuType == MenuType.BEVERAGE);
    }
}

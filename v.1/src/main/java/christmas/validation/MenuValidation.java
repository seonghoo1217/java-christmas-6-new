package christmas.validation;

import christmas.domain.menu.Menu;
import christmas.domain.menu.MenuType;
import christmas.domain.menu.RestaurantManager;
import christmas.tool.MenuExtractTool;

import java.util.HashSet;
import java.util.List;

import static christmas.property.ErrorProperty.ERROR_CONTAIN_SPACE_VALUE;
import static christmas.property.ErrorProperty.ERROR_INVALIDATE_ORDER_MENU_INPUT;
import static christmas.validation.property.ValidationProperty.MAX_ORDER;
import static christmas.validation.property.ValidationProperty.MIN_ORDER;

public class MenuValidation {

    private static MenuExtractTool menuExtractTool = new MenuExtractTool();

    public void verifyForMenus(String orderMenus) {
        verifyForOrderContainSpace(orderMenus);
        verifyForOrderCorrectFormat(orderMenus);
        verifyForOrderMenuDuplicate(orderMenus);
        verifyForOrderCount(orderMenus);
        verifyForOrderOnlyBeverage(orderMenus);
    }

    private void verifyForOrderContainSpace(String orderMenus) {
        if (!orderMenus.replaceAll(" ", "").equals(orderMenus)) {
            throw new IllegalArgumentException(ERROR_CONTAIN_SPACE_VALUE);
        }
    }

    private void verifyForOrderCorrectFormat(String orderMenus) {
        if (!orderMenus.matches("^([가-힣a-zA-Z0-9]+-\\d+)(,[가-힣a-zA-Z0-9]+-\\d+)*$")) {
            throw new IllegalArgumentException(ERROR_INVALIDATE_ORDER_MENU_INPUT);
        }
    }

    private void verifyForOrderMenuDuplicate(String orderMenus) {
        List<String> menuNames = menuExtractTool.extractMenuNames(orderMenus);
        if (menuNames.size() != new HashSet<>(menuNames).size()) {
            throw new IllegalArgumentException(ERROR_INVALIDATE_ORDER_MENU_INPUT);
        }
        verifyForOrderMenuExist(menuNames);
    }

    private void verifyForOrderMenuExist(List<String> orderMenuNames) {
        if (!menuNameIsExist(orderMenuNames)) {
            throw new IllegalArgumentException(ERROR_INVALIDATE_ORDER_MENU_INPUT);
        }
    }


    private void verifyForOrderCount(String orderMenus) {
        int orderCount = menuExtractTool.extractOrderCount(orderMenus);
        if (orderCount < MIN_ORDER || orderCount > MAX_ORDER) {
            throw new IllegalArgumentException(ERROR_INVALIDATE_ORDER_MENU_INPUT);
        }
    }

    private void verifyForOrderOnlyBeverage(String orderMenus) {
        List<MenuType> menuTypes = menuExtractTool.extractMenuType(orderMenus);
        if (menusIsOnlyBeverage(menuTypes)) {
            throw new IllegalArgumentException(ERROR_INVALIDATE_ORDER_MENU_INPUT);
        }
    }

    private boolean menuNameIsExist(List<String> orderMenuNames) {
        return orderMenuNames.stream().allMatch(getMenuNames()::contains);
    }

    private List<String> getMenuNames() {
        return RestaurantManager.getMenus().stream().map(Menu::name).toList();
    }

    private boolean menusIsOnlyBeverage(List<MenuType> menuTypes) {
        return menuTypes.stream().allMatch(menuType -> menuType == MenuType.BEVERAGE);
    }
}

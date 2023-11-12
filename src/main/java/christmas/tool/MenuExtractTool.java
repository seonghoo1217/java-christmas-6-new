package christmas.tool;

import christmas.domain.menu.Menu;
import christmas.domain.menu.MenuManager;
import christmas.domain.menu.MenuType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static christmas.property.ErrorProperty.ERROR_TOO_MANY_ORDER;

public class MenuExtractTool {
    public List<MenuType> extractMenuType(String orderMenus) {
        return Arrays.stream(orderMenus.split(","))
                .map(item -> item.split("-")[0])
                .flatMap(menuName ->
                        MenuManager.getMenus().stream()
                                .filter(menu -> menu.getName().equals(menuName))
                                .map(Menu::getMenuType))
                .collect(Collectors.toList());
    }

    public List<String> extractMenuNames(String orderMenus) {
        List<String> menuNames = new ArrayList<>();
        String[] orderItems = orderMenus.split(",");

        for (String item : orderItems) {
            String menuName = item.split("-")[0];
            menuNames.add(menuName);
        }

        return menuNames;
    }

    public int extractOrderCount(String orderMenus) {
        long orderCount = 0;
        String[] orderItems = orderMenus.split(",");

        for (String item : orderItems) {
            orderCount = Long.parseLong(item.split("-")[1]);
        }
        if (orderCount > Integer.MAX_VALUE) {
            throw new IllegalArgumentException(ERROR_TOO_MANY_ORDER);
        }
        return (int) orderCount;
    }
}

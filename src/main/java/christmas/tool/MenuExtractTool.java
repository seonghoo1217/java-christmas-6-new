package christmas.tool;

import christmas.domain.menu.Menu;
import christmas.domain.menu.MenuType;
import christmas.domain.menu.RestaurantManager;

import java.util.*;
import java.util.stream.Collectors;

import static christmas.property.ErrorProperty.ERROR_TOO_MANY_ORDER;

public class MenuExtractTool {
    public List<MenuType> extractMenuType(String orderMenus) {
        return Arrays.stream(orderMenus.split(","))
                .map(item -> item.split("-")[0])
                .flatMap(menuName ->
                        RestaurantManager.getMenus().stream()
                                .filter(menu -> menu.name().equals(menuName))
                                .map(Menu::menuType))
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

    public Map<String, Integer> extractOrderStatus(String orderMenus) {
        Map<String, Integer> orderStatus = new LinkedHashMap<>();
        String[] orderItems = orderMenus.split(",");
        for (String item : orderItems) {
            orderStatus.put(item.split("-")[0], Integer.parseInt(item.split("-")[1]));
        }
        return orderStatus;
    }

    public Integer extractTotalAmount(Map<String, Integer> orderStatus, String orderMenus) {
        LinkedList<Menu> menus = extractMenus(orderMenus);
        return menus.stream()
                .filter(m -> orderStatus.containsKey(m.name()))
                .mapToInt(m -> m.cost() * orderStatus.get(m.name()))
                .sum();
    }

    public LinkedList<Menu> extractMenus(String orderMenus) {
        List<String> menuNames = extractMenuNames(orderMenus);
        return RestaurantManager.getMenus().stream()
                .filter(menu -> menuNames.contains(menu.name()))
                .collect(Collectors.toCollection(LinkedList::new));
    }

    public Menu extractMenuByMenuName(List<Menu> menus, String menuName) {
        return menus.stream()
                .filter(menu -> menu.name().equals(menuName))
                .findFirst()
                .orElse(null);
    }
}

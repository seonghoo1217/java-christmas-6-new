package christmas.domain.menu;

import christmas.domain.menu.property.MenuProperty;
import christmas.domain.order.Order;
import christmas.tool.MenuExtractTool;
import christmas.validation.MenuValidation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RestaurantManager {

    private static final List<Menu> menus = new ArrayList<>();
    private final Order order;

    private static final MenuExtractTool menuExtractTool = new MenuExtractTool();

    public RestaurantManager(String orderMenus) {
        initializeRestaurantMenu();
        validate(orderMenus);
        Map<String, Integer> orderStatus = menuExtractTool.extractOrderStatus(orderMenus);
        order = new Order(orderStatus, menuExtractTool.extractTotalAmount(orderStatus, orderMenus));
    }

    public void addMenu(Menu menu) {
        menus.add(menu);
    }

    private void initializeRestaurantMenu() {
        for (MenuProperty menuProperty : MenuProperty.values()) {
            addMenu(new Menu(menuProperty.menuName, menuProperty.menuCost, menuProperty.menuType));
        }
    }

    private void validate(String orderMenus) {
        MenuValidation menuValidation = new MenuValidation();
        menuValidation.verifyForMenus(orderMenus);
    }

    public static List<Menu> getMenus() {
        return menus;
    }

    public Order getOrder() {
        return order;
    }

    public Integer promotionDiscountWeekOfDay(MenuType menuType, Integer cost) {
        Map<String, Integer> orderStatus = order.orderStatus();
        int totalOrderCount = 0;
        for (Map.Entry<String, Integer> entry : orderStatus.entrySet()) {
            String menuName = entry.getKey();
            Integer count = entry.getValue();
            Menu foundMenu = menuExtractTool.extractMenuByMenuName(menus, menuName);
            if (foundMenu != null && foundMenu.menuType().equals(menuType)) {
                totalOrderCount += count;
            }
        }
        return totalOrderCount * cost;
    }
}

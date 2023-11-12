package christmas.domain.menu;

import christmas.domain.menu.property.MenuProperty;
import christmas.domain.order.Order;
import christmas.validation.MenuValidation;

import java.util.ArrayList;
import java.util.List;

public class RestaurantManager {

    private static final List<Menu> menus = new ArrayList<>();
    private final Order order;

    public RestaurantManager(String orderMenus) {
        initializeRestaurantMenu();
        validate(orderMenus);
        order = new Order(orderMenus);
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
}

package christmas.domain.menu;

import christmas.domain.menu.property.MenuProperty;
import christmas.validation.MenuValidation;

import java.util.ArrayList;
import java.util.List;

public class MenuManager {

    private static final List<Menu> menus = new ArrayList<>();

    public MenuManager(String orderMenus) {
        initializeRestaurantMenu();
        validate(orderMenus);
    }

    private void addMenu(Menu menu) {
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
}

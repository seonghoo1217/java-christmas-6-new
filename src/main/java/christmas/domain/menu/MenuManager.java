package christmas.domain.menu;

import christmas.domain.menu.property.MenuProperty;

import java.util.ArrayList;
import java.util.List;

public class MenuManager {

    private List<Menu> menus = new ArrayList<>();

    public MenuManager() {
        initializeRestaurantMenu();
    }

    private void addMenu(Menu menu) {
        menus.add(menu);
    }

    private void initializeRestaurantMenu() {
        for (MenuProperty menuProperty : MenuProperty.values()) {
            addMenu(new Menu(menuProperty.menuName, menuProperty.menuCost, menuProperty.menuType));
        }
    }

    public List<Menu> getMenus() {
        return menus;
    }
}

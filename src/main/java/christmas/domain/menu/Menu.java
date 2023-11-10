package christmas.domain.menu;

public class Menu {

    private String name;
    private Integer cost;
    private MenuType menuType;

    public Menu(String name, Integer cost, MenuType menuType) {
        this.name = name;
        this.cost = cost;
        this.menuType = menuType;
    }
}

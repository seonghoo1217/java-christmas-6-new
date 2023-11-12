package christmas.domain.menu.property;

import christmas.domain.menu.MenuType;

import static christmas.domain.menu.MenuType.*;

public enum MenuProperty {
    양송이수프("양송이수프", 6000, APPETIZER),
    타파스("타파스", 5000, APPETIZER),
    시저샐러드("시저샐러드", 8000, APPETIZER),
    티본스테이크("티본스테이크", 55000, MAIN_DISH),
    바비큐립("바비큐립", 54000, MAIN_DISH),
    해산물파스타("해산물파스타", 35000, MAIN_DISH),
    크리스마스파스타("크리스마스파스타", 25000, MAIN_DISH),
    초코케이크("초코케이크", 15000, DESSERT),
    아이스크림("아이스크림", 5000, DESSERT),
    제로콜라("제로콜라", 3000, BEVERAGE),
    레드와인("레드와인", 60000, BEVERAGE),
    샴페인("샴페인", 25000, BEVERAGE);


    public String menuName;
    public Integer menuCost;
    public MenuType menuType;

    MenuProperty(String menuName, Integer menuCost, MenuType menuType) {
        this.menuName = menuName;
        this.menuCost = menuCost;
        this.menuType = menuType;
    }
}

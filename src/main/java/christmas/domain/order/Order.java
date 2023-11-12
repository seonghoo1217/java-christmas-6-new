package christmas.domain.order;

import christmas.tool.MenuExtractTool;

import java.util.Map;

public class Order {
    private final Map<String, Integer> orderStatus;
    private final Integer totalAmount;

    private static final MenuExtractTool menuExtractTool = new MenuExtractTool();


    public Order(String orderMenus) {
        this.orderStatus = parsingOrderStatus(orderMenus);
        this.totalAmount = parsingTotalAmount(orderMenus);
    }

    private Map<String, Integer> parsingOrderStatus(String orderMenus) {
        return menuExtractTool.extractOrderStatus(orderMenus);
    }

    private Integer parsingTotalAmount(String orderMenus) {
        return menuExtractTool.extractTotalAmount(orderMenus);
    }
}

package christmas.view;

import java.util.Map;

import static christmas.view.property.OutputProperty.EVENT_NOTICE;
import static christmas.view.property.OutputProperty.ORDER_MENUS;

public class OutputView {
    public static void outputForInputErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    public void outputForEventNotice() {
        System.out.println(EVENT_NOTICE);
        outputForLineBreak();
    }

    public void outputForOrderMenus(Map<String, Integer> orderStatus) {
        System.out.println(ORDER_MENUS);
        orderStatus.keySet().forEach(key -> System.out.println(key + " " + orderStatus.get(key) + "개"));
        outputForLineBreak();
    }

    private void outputForLineBreak() {
        System.out.println();
    }
}

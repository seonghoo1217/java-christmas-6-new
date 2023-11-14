package christmas.view;

import christmas.tool.StringFormatTool;

import java.util.Map;

import static christmas.view.property.OutputProperty.*;

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

    public void outputForTotalAmount(Integer totalAmount) {
        System.out.println(TOTAL_AMOUNT);
        System.out.println(StringFormatTool.parsingCostFormatWon(totalAmount));
    }

    private void outputForLineBreak() {
        System.out.println();
    }
}

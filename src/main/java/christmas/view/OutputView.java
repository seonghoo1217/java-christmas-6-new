package christmas.view;

import static christmas.view.property.OutputProperty.EVENT_NOTICE;

public class OutputView {
    public static void outputForInputErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    public void outputForEventNotice() {
        System.out.println(EVENT_NOTICE);
        outputForLineBreak();
    }

    private void outputForLineBreak() {
        System.out.println();
    }
}

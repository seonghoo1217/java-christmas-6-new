package christmas.tool;

import java.text.NumberFormat;
import java.util.Locale;

public class StringFormatTool {

    public static String parsingCostFormatWon(Integer cost) {
        return NumberFormat.getCurrencyInstance(Locale.KOREA).format(cost)
                .replace("₩", "")
                .concat("원");
    }

    public static String parsingBracesRemove(String target) {
        return target.replace("[", "").replace("]", "");
    }
}

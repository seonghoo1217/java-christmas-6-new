package christmas.tool;

import christmas.domain.event.Event;
import christmas.domain.event.EventManager;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import static christmas.view.property.OutputProperty.*;

public class EventDetailGenerateTool {
    public final StringBuilder sb = new StringBuilder();

    public String eventResultGenerate(EventManager eventManager, Integer totalAmount) {
        LinkedList<Event> events = eventManager.getEvents();

        generatePresentMenu(Objects.requireNonNull(events.poll()));
        generatePromotionDetail(events);
        generateTotalPromotionAmount(eventManager.promotionAmount(events));
        generatePromotionResultAmount(eventManager.promotionAmountWithOut(events), totalAmount);
        return this.sb.toString();
    }

    private void generatePresentMenu(Event event) {
        sb.append(PRESENT_MENU);
        appendLineBreak();
        sb.append(event.getPromotionContetns());
        appendLineBreak();
        appendLineBreak();
    }

    private void generatePromotionDetail(List<Event> events) {
        sb.append(PROMOTION_DETAILS);
        appendLineBreak();
        for (Event e : events) {
            sb.append(e.getPromotionContetns()).append(" : ")
                    .append(PROMOTION_AMOUNT_PREFIX)
                    .append(StringFormatTool.parsingCostFormatWon(e.getPromotionPrice()));
            appendLineBreak();
        }
        appendLineBreak();
    }

    private void generateTotalPromotionAmount(Integer totalPromotionAmount) {
        sb.append(PROMOTION_AMOUNT);
        appendLineBreak();
        sb.append(PROMOTION_AMOUNT_PREFIX).append(StringFormatTool.parsingCostFormatWon(totalPromotionAmount));
        appendLineBreak();
        appendLineBreak();
    }

    private void generatePromotionResultAmount(Integer totalPromotionAmount, Integer totalAmount) {
        sb.append(AFTER_PAYMENT_AMOUNT);
        appendLineBreak();
        sb.append(StringFormatTool.parsingCostFormatWon(totalAmount - totalPromotionAmount));
        appendLineBreak();
    }

    private void appendLineBreak() {
        sb.append("\n");
    }
}

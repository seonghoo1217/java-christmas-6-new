package christmas.domain.event;

public class Event {
    private final Integer promotionPrice;
    private final String promotionContetns;

    public Event(Integer promotionPrice, String promotionContetns) {
        this.promotionPrice = promotionPrice;
        this.promotionContetns = promotionContetns;
    }

    public Integer getPromotionPrice() {
        return promotionPrice;
    }

    public String getPromotionContetns() {
        return promotionContetns;
    }
}

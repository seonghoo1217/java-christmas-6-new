package christmas.domain.event;

import static christmas.domain.event.property.PromotionProperty.*;

public enum Event {
    NO_PROMOTION(NO_PROMOTION_PRICE, NO_PROMOTION_CONTENTS),
    PRESENTATION(PRESENTATION_PRICE, PRESENTATION_CONTENTS);

    private final Integer promotionPrice;
    private final String promotionContetns;

    Event(Integer promotionPrice, String promotionContetns) {
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

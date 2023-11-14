package christmas.domain.event;

import static christmas.domain.event.property.PromotionProperty.PRESENTATION_CONTENTS;
import static christmas.domain.event.property.PromotionProperty.PRESENTATION_PRICE;

public enum Event {
    PRESENTATION(PRESENTATION_PRICE, PRESENTATION_CONTENTS);

    private final Integer promotionPrice;
    private final String promotionContetns;

    Event(Integer promotionPrice, String promotionContetns) {
        this.promotionPrice = promotionPrice;
        this.promotionContetns = promotionContetns;
    }
}

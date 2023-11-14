package christmas.domain.event;

public enum Badge {
    별, 나무, 산타;

    public static Badge rewardBadge(Integer promotionAmount) {
        if (promotionAmount > 20000) {
            return 산타;
        }
        if (promotionAmount > 10000) {
            return 나무;
        }
        return 별;
    }
}

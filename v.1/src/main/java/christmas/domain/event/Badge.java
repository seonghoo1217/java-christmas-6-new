package christmas.domain.event;

public enum Badge {
    별, 나무, 산타, 없음;

    public static Badge rewardBadge(Integer promotionAmount) {
        if (promotionAmount >= 20000) {
            return 산타;
        }
        if (promotionAmount >= 10000) {
            return 나무;
        }
        if (promotionAmount >= 5000) {
            return 별;
        }
        return 없음;
    }
}

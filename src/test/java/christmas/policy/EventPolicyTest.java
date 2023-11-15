package christmas.policy;

import christmas.core.EventCheckPolicy;
import christmas.core.EventPolicy;
import christmas.domain.calender.Calendar;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EventPolicyTest {

    @Test
    void EventPolicy_이벤트_대상자_10000원이상구매_테스트() {
        //given
        Integer totalAmount = 10000;

        //when
        boolean eventTarget = eventPolicy().orderIsEventTarget(totalAmount);

        //then
        assertThat(eventTarget).isTrue();
    }

    @Test
    void EventPolicy_증정_이벤트_대상자_테스트() {
        //given
        Integer totalAmount = 120000;

        //when
        boolean eventTarget = eventPolicy().giveAwayEvent(totalAmount);

        //then
        assertThat(eventTarget).isTrue();
    }

    @Test
    void EventPolicy_디데이_프로모션_이벤트_테스트() {
        //given
        Calendar calendar = calendar();

        //when
        Integer promotionAmount = eventPolicy().christmasDDayPromotion(calendar);

        //then
        assertThat(promotionAmount).isEqualTo(3400);
    }

    @Test
    void EventPolicy_평일_판별_로직_테스트() {
        //given
        Calendar calendar = calendar();
        //when
        boolean dateIsWeekDay = eventPolicy().dateIsWeekDay(calendar);
        assertThat(dateIsWeekDay).isTrue();
    }

    @Test
    void EventPolicy_이벤트_특별_할인_대상_판별_로직_테스트() {
        //given
        Calendar calendar = calendar();

        //when
        Integer promotionAmount = eventPolicy().dateIsSpecialPromotionTarget(calendar);

        //then
        assertThat(promotionAmount).isEqualTo(1000);
    }

    private EventPolicy eventPolicy() {
        return new EventCheckPolicy();
    }

    private Calendar calendar() {
        return new Calendar("25", 2023, 12);
    }
}

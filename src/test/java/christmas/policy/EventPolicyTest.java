package christmas.policy;

import christmas.core.EventCheckPolicy;
import christmas.core.EventPolicy;
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

    private EventPolicy eventPolicy() {
        return new EventCheckPolicy();
    }
}

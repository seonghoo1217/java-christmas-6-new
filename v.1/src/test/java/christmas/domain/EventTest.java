package christmas.domain;

import christmas.domain.event.Badge;
import christmas.domain.event.Event;
import christmas.domain.event.EventManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static christmas.domain.event.property.PromotionProperty.*;
import static org.assertj.core.api.Assertions.assertThat;

public class EventTest {

    @ParameterizedTest
    @MethodSource("generateEvents")
    void Event_생성_후_총_프로모션_증정혜택_가격_로직_테스트(List<Event> events) {
        //given
        EventManager eventManager = new EventManager();

        //when
        Integer promotionAmount = eventManager.promotionAmount(events);

        //then
        assertThat(promotionAmount).isEqualTo(31046);
    }

    @ParameterizedTest
    @MethodSource("generateEvents")
    void Event_생성_후_프로모션_증정이벤트_제외_총_가격_로직_테스트(List<Event> events) {
        //given
        EventManager eventManager = new EventManager();

        //when
        Integer promotionAmount = eventManager.promotionAmountWithOut(events);

        //then
        assertThat(promotionAmount).isEqualTo(6046);
    }

    @Test
    void Badge_총_금액을_통해_생성_별_인_경우() {
        //given
        Integer promotionAmount = 5000;

        //when
        Badge rewardBadge = Badge.rewardBadge(promotionAmount);

        //then
        assertThat(rewardBadge).isEqualTo(Badge.별);
    }

    @Test
    void Badge_총_금액을_통해_생성_나무_인_경우() {
        //given
        Integer promotionAmount = 10000;

        //when
        Badge rewardBadge = Badge.rewardBadge(promotionAmount);

        //then
        assertThat(rewardBadge).isEqualTo(Badge.나무);
    }

    @Test
    void Badge_총_금액을_통해_생성_산타_인_경우() {
        //given
        Integer promotionAmount = 20000;

        //when
        Badge rewardBadge = Badge.rewardBadge(promotionAmount);

        //then
        assertThat(rewardBadge).isEqualTo(Badge.산타);
    }

    @Test
    void Badge_총_금액을_통해_생성_없음_인_경우() {
        //given
        Integer promotionAmount = 3000;

        //when
        Badge rewardBadge = Badge.rewardBadge(promotionAmount);

        //then
        assertThat(rewardBadge).isEqualTo(Badge.없음);
    }


    static Stream<Arguments> generateEvents() {
        List<Event> events = new ArrayList<>();
        events.add(new Event(1000, D_DAY_PROMOTION_CONTENTS));
        events.add(new Event(4046, WEEKDAY_PROMOTION_CONTENTS));
        events.add(new Event(1000, SPECIAL_PROMOTION_CONTENTS));
        events.add(new Event(PRESENTATION_PRICE, PRESENTATION_DETAIL_CONTENTS));
        return Stream.of(
                Arguments.arguments(events)
        );
    }
}

package christmas.domain;

import christmas.domain.event.Event;
import christmas.domain.event.EventManager;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static christmas.domain.event.property.PromotionProperty.*;
import static org.assertj.core.api.Assertions.assertThat;

public class EventManagerTest {

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


    static Stream<Arguments> generateEvents() {
        List<Event> events = new ArrayList<>();
        events.add(new Event(1000, D_DAY_PROMOTION_CONTENTS));
        events.add(new Event(4046, WEEKDAY_PROMOTION_CONTENTS));
        events.add(new Event(1000, SPECIAL_PROMOTION_CONTENTS));
        events.add(new Event(PRESENTATION_PRICE, PRESENTATION_CONTENTS));
        return Stream.of(
                Arguments.arguments(events)
        );
    }
}

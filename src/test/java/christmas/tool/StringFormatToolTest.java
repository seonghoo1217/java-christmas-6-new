package christmas.tool;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringFormatToolTest {

    @Test
    void 숫자입력시_한국_돈_형식으로_반환_테스트() {
        //given
        Integer targetCost = 150000;

        //when
        String parsingCost = StringFormatTool.parsingCostFormatWon(targetCost);

        //then
        assertThat(parsingCost).isEqualTo("150,000원");
    }
}

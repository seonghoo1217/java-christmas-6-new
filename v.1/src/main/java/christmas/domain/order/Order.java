package christmas.domain.order;

import java.util.Map;

public record Order(Map<String, Integer> orderStatus, Integer totalAmount) {

}

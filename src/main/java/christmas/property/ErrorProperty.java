package christmas.property;

public class ErrorProperty {
    private static final String errorPrefix = "[ERROR] ";
    public static final String ERROR_INVALIDATE_DATE_RANGE = errorPrefix + "날짜는 1 ~ 31 사이의 값이 입력 되어야 합니다. ";
    public static final String ERROR_INVALIDATE_DATE_NOT_NUMERIC = errorPrefix + "날짜는 숫자 형태의 값외에는 허용하지 않습니다";
    public static final String ERROR_ORDER_NOT_CORRECT_FORMAT = errorPrefix + "주문 양식은 [주문이름]-[개수]이며, 주문을 여러개 할 경우 콤마(,)를 사용하셔야 합니다.";
}

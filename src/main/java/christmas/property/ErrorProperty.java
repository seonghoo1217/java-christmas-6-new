package christmas.property;

public class ErrorProperty {
    private static final String errorPrefix = "[ERROR] ";
    public static final String ERROR_INVALIDATE_DATE_RANGE = errorPrefix + "날짜는 1 ~ 31 사이의 값이 입력 되어야 합니다.";
    public static final String ERROR_INVALIDATE_DATE_NOT_NUMERIC = errorPrefix + "날짜는 숫자 형태의 값외에는 허용하지 않습니다";
    public static final String ERROR_ORDER_NOT_CORRECT_FORMAT = errorPrefix + "주문 양식은 [주문 이름]-[개수]이며, 주문을 여러개 할 경우 콤마(,)를 사용하셔야 합니다.";
    public static final String ERROR_ORDER_IS_DUPLICATE = errorPrefix + "주문시 메뉴가 중복되어서는 안됩니다.";
    public static final String ERROR_ORDER_MENU_IS_NOT_EXIST = errorPrefix + "주문하신 메뉴가 존재하지 않습니다. 존재하는 메뉴로 주문하여 주세요.";
    public static final String ERROR_ORDER_COUNT = errorPrefix + "주문은 최소 1개 최대 20개를 주문해 주세요.";
}

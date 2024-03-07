package constant;

public enum Message {

    INPUT_TOUR_ID("Input tour ID"),
    INPUT_TOUR_NAME("Input tour name"),
    INPUT_TOUR_DESTINATION("Input destination of the tour"),
    INPUT_TOUR_DURATION("Input duration of the tour (days)"),
    INPUT_TOUR_DESCRIPTION("Input tour description"),
    INPUT_TOUR_PRICE("Input price of the tour"),

    ENTER_NOT_NULL("Please enter not null"),
    INVALID_DATA("Invalid data. Please try again."),
    WANT_TO_DELETE("Do you want to delete?"),
    WANT_TO_CONTINUE("Do you want to continue?"),
    ENTER_TO_KEEP_OLD("Enter to keep old value");

    private final String pattern;

    public String getPattern() {
        return pattern;
    }

    Message(String pattern) {
        this.pattern = pattern;
    }
}

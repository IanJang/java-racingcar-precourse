package racing;

public class CarName {
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;
    private static final String ILLEGAL_LENGTH_MESSAGE = String.format(
            "이름의 길이는 %d~%d자만 가능합니다.", MIN_LENGTH, MAX_LENGTH);

    private final String name;

    public CarName(String name) {
        if (name.length() < MIN_LENGTH || name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(ILLEGAL_LENGTH_MESSAGE);
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

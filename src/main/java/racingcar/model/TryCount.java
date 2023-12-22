package racingcar.model;

public class TryCount {

    private static final int ZERO = 0;

    private final int count;

    private TryCount(final int count) {
        if (count < ZERO) {
            throw new IllegalArgumentException();
        }
        this.count = count;
    }

    public static TryCount valueOf(final int count) {
        return new TryCount(count);
    }

    TryCount decrease() {
        return new TryCount(Math.max(ZERO, count - 1));
    }

    boolean isZero() {
        return count == ZERO;
    }
}

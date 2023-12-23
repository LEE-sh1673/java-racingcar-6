package racingcar.model;

import java.util.Objects;

class Position {

    private static final int INITIAL_POSITION = 0;

    private final int position;

    Position() {
        this(INITIAL_POSITION);
    }

    private Position(final int position) {
        if (position < INITIAL_POSITION) {
            throw new IllegalArgumentException();
        }
        this.position = position;
    }

    static Position zero() {
        return new Position(INITIAL_POSITION);
    }

    Position move() {
        return new Position(position + 1);
    }

    Position max(final Position other) {
        if (position > other.position) {
            return this;
        }
        return other;
    }

    int position() {
        return position;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Position other = (Position) o;
        return position == other.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}

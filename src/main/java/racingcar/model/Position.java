package racingcar.model;

import java.util.Objects;

class Position implements Comparable<Position> {

    private static final int INITIAL_POSITION = 0;

    private final int position;

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

    int intValue() {
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

    @Override
    public int compareTo(final Position other) {
        return position - other.position;
    }
}

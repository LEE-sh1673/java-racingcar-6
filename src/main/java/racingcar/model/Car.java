package racingcar.model;

import java.util.Objects;

class Car {

    private final Name name;
    private final Position position;

    private Car(final Name name, final Position position) {
        this.name = name;
        this.position = position;
    }

    static Car withName(final String name) {
        return new Car(Name.create(name), Position.zero());
    }

    Car move(final MovingStrategy strategy) {
        if (strategy.movable()) {
            return new Car(name, position.move());
        }
        return this;
    }

    String getName() {
        return name.name();
    }

    int getPosition() {
        return position.position();
    }

    boolean isWinner(final Position other) {
        return position.equals(other);
    }

    Position max(final Position other) {
        return position.max(other);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Car other = (Car) o;
        return name.equals(other.name) && position.equals(other.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}

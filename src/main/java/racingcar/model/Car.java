package racingcar.model;

class Car implements Comparable<Car> {

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
        return name.getName();
    }

    Position getPosition() {
        return position;
    }

    boolean matchPosition(final Position other) {
        return position.equals(other);
    }

    @Override
    public int compareTo(final Car other) {
        return this.position.compareTo(other.position);
    }
}

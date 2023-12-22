package racingcar.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {

    private final List<Car> cars;

    Cars(final List<String> names) {
        validateDuplicate(names);
        this.cars = makeCars(names);
    }

    private void validateDuplicate(final List<String> names) {
        final Set<String> uniqueNames = new HashSet<>(names);

        if (names.size() != uniqueNames.size()) {
            throw new IllegalArgumentException();
        }
    }

    private List<Car> makeCars(final List<String> carNames) {
        return carNames.stream()
                .map(Car::withName)
                .toList();
    }

    public static Cars withNames(final List<String> names) {
        return new Cars(names);
    }

    void move(final MovingStrategy movingStrategy) {
        cars.forEach(car -> car.move(movingStrategy));
    }

    List<Car> findWinners() {
        final Position maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.matchPosition(maxPosition))
                .toList();
    }

    private Position getMaxPosition() {
        return Collections.max(cars).getPosition();
    }

    List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}

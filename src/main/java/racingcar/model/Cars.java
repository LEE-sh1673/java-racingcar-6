package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {

    private final List<Car> cars;

    private Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public static Cars withNames(final List<String> names) {
        validateDuplicate(names);
        return new Cars(makeCars(names));
    }

    private static void validateDuplicate(final List<String> names) {
        final Set<String> uniqueNames = new HashSet<>(names);
        if (names.size() != uniqueNames.size()) {
            throw new IllegalArgumentException();
        }
    }

    private static List<Car> makeCars(final List<String> carNames) {
        return carNames.stream()
            .map(Car::withName)
            .toList();
    }

    Cars move(final MovingStrategy movingStrategy) {
        final List<Car> moved = new ArrayList<>();
        for (final Car car : cars) {
            moved.add(car.move(movingStrategy));
        }
        return new Cars(moved);
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

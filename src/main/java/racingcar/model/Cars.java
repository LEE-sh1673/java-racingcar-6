package racingcar.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.platform.commons.util.StringUtils;

public class Cars {

    private static final String NAME_SPLITTER = ",";

    private final List<Car> cars;

    private Cars(final List<Car> cars) {
        this.cars = cars;
    }

    static Cars withNames(final String carNames) {
        if (StringUtils.isBlank(carNames)) {
            throw new IllegalArgumentException();
        }
        return new Cars(split(carNames));
    }

    private static List<Car> split(final String carNames) {
        final List<String> splitNames = List.of(carNames.split(NAME_SPLITTER));
        validateNameDuplicated(splitNames);

        return splitNames.stream()
                .map(Car::withName)
                .toList();
    }

    private static void validateNameDuplicated(final List<String> names) {
        final Set<String> uniqueNames = new HashSet<>(names);
        if (names.size() != uniqueNames.size()) {
            throw new IllegalArgumentException();
        }
    }

    Cars move(final MovingStrategy movingStrategy) {
        final List<Car> moved = cars.stream()
                .map(car -> car.move(movingStrategy))
                .toList();
        return new Cars(moved);
    }

    Winners findWinners() {
        return winners(maxPosition());
    }

    private Position maxPosition() {
        Position maxPosition = new Position();
        for (final Car car : cars) {
            maxPosition = car.max(maxPosition);
        }
        return maxPosition;
    }

    private Winners winners(final Position maxPosition) {
        final Winners winners = new Winners();

        for (final Car car : cars) {
            if (car.matchPosition(maxPosition)) {
                winners.addWinner(car);
            }
        }
        return winners;
    }

    public Iterable<Car> cars() {
        return Collections.unmodifiableList(cars);
    }
}

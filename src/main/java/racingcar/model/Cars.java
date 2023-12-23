package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.platform.commons.util.StringUtils;

class Cars {

    private static final String NAME_SPLITTER = ",";

    private final List<Car> cars;

    private Cars(final List<Car> cars) {
        validateDuplicate(cars);
        this.cars = cars;
    }

    private void validateDuplicate(final List<Car> cars) {
        final Set<Car> uniqueCars = new HashSet<>(cars);

        if (cars.size() != uniqueCars.size()) {
            throw new IllegalArgumentException();
        }
    }

    static Cars withNames(final String carNames) {
        if (StringUtils.isBlank(carNames)) {
            throw new IllegalArgumentException("자동차 이름은 값이 존재해야 합니다.");
        }
        return new Cars(split(carNames));
    }

    private static List<Car> split(final String carNames) {
        return Arrays.stream(carNames.split(NAME_SPLITTER))
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
            if (car.isWinner(maxPosition)) {
                winners.addWinner(car);
            }
        }
        return winners;
    }

    Iterable<Car> cars() {
        return Collections.unmodifiableList(cars);
    }
}

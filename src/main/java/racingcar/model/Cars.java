package racingcar.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import racingcar.utils.StringUtils;

public class Cars {

    private static final String NAME_SPLITTER = ",";

    private final List<Car> cars;

    private Cars(final List<Car> cars) {
        if (cars.size() != new HashSet<>(cars).size()) {
            throw new IllegalArgumentException();
        }
        this.cars = cars;
    }

    static Cars withNames(final String carNames) {
        if (StringUtils.isBlank(carNames)) {
            throw new IllegalArgumentException();
        }
        return new Cars(split(carNames));
    }

    private static List<Car> split(final String carNames) {
        return Arrays.stream(carNames.split(NAME_SPLITTER))
                .map(Car::withName)
                .toList();
    }

    Cars move(final MovingStrategy movingStrategy) {
        return new Cars(moveBy(movingStrategy));
    }

    private List<Car> moveBy(final MovingStrategy movingStrategy) {
        return cars.stream()
                .map(car -> car.move(movingStrategy))
                .toList();
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

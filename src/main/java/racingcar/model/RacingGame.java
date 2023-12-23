package racingcar.model;

import java.util.List;

import racingcar.model.dto.CarDto;
import racingcar.model.dto.Winners;

public class RacingGame {

    private Cars cars;

    private TryCount count;

    public RacingGame(final Cars cars, final TryCount count) {
        this.cars = cars;
        this.count = count;
    }

    public void race(final MovingStrategy movingStrategy) {
        cars = cars.move(movingStrategy);
        count = count.decrease();
    }

    public List<CarDto> getCars() {
        return cars.getCars().stream()
            .map(this::toCarDto)
            .toList();
    }

    private CarDto toCarDto(final Car car) {
        return new CarDto(car.getName(), car.getPosition().intValue());
    }

    public Winners getWinners() {
        return new Winners(getNames(cars.findWinners()));
    }

    private List<String> getNames(final List<Car> winners) {
        return winners.stream()
            .map(Car::getName)
            .toList();
    }

    public boolean isFinish() {
        return count.isZero();
    }
}

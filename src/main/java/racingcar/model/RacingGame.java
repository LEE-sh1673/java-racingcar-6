package racingcar.model;

public class RacingGame {

    private Cars cars;
    private TryCount count;

    public RacingGame(final String carNames, final int tryCount) {
        this(Cars.withNames(carNames), TryCount.valueOf(tryCount));
    }

    RacingGame(final Cars cars, final TryCount count) {
        this.cars = cars;
        this.count = count;
    }

    public boolean isRacing() {
        return !count.isZero();
    }

    public void race(final MovingStrategy movingStrategy) {
        cars = cars.move(movingStrategy);
        count = count.decrease();
    }

    public Cars getCars() {
        return cars;
    }

    public Winners getWinners() {
        return cars.findWinners();
    }
}

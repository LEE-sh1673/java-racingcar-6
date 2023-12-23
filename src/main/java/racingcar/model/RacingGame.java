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

    public void race(final MovingStrategy movingStrategy) {
        cars = cars.move(movingStrategy);
        count = count.decrease();
    }

    public RacingResult getResult() {
        final RacingResult result = new RacingResult();

        for (final Car car : cars.cars()) {
            result.report(car);
        }
        return result;
    }

    public Winners getWinners() {
        return cars.findWinners();
    }

    public boolean isRacing() {
        return !count.isZero();
    }
}

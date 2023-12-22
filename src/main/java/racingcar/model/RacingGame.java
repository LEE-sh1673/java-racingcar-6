package racingcar.model;

public class RacingGame {

    private final Cars cars;

    private TryCount count;

    public RacingGame(final Cars cars, final TryCount count) {
        this.cars = cars;
        this.count = count;
    }

    public void race(final MovingStrategy movingStrategy) {
        cars.move(movingStrategy);
        count = count.decrease();
    }

    public RacingResult getResult() {
        return new RacingResult(cars.getCars());
    }

    public Winners getWinners() {
        return new Winners(cars.findWinners());
    }

    public boolean isFinish() {
        return count.isZero();
    }
}

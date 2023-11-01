package racingcar;

public record RaceScore(String name, int score) {

    public static RaceScore from(final Car car) {
        return new RaceScore(car.getName(), car.getPosition());
    }
}

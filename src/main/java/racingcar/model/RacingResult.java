package racingcar.model;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class RacingResult {

    private static final String RESULT_DELIMITER = "\n";
    private static final String RESULT_LINE_FORMAT = "%s : %s";
    private static final String DASH = "-";

    private final List<Car> cars;

    RacingResult() {
        this(new ArrayList<>());
    }

    private RacingResult(final List<Car> cars) {
        this.cars = cars;
    }

    void report(final Car car) {
        cars.add(car);
    }

    public String results() {
        final StringJoiner message = new StringJoiner(RESULT_DELIMITER);
        for (final Car car : cars) {
            message.add(result(car));
        }
        return message.toString();
    }

    private String result(final Car car) {
        return String.format(RESULT_LINE_FORMAT, car.getName(), DASH.repeat(car.getPosition()));
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final RacingResult other = (RacingResult) o;
        return Objects.equals(cars, other.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}

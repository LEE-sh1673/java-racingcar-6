package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class Winners {

    private final List<Car> winners;

    Winners() {
        this(new ArrayList<>());
    }

    private Winners(final List<Car> winners) {
        this.winners = winners;
    }

    void addWinner(final Car car) {
        winners.add(car);
    }

    public String names() {
        final StringJoiner message = new StringJoiner(",");
        for (final Car car : winners) {
            message.add(car.getName());
        }
        return message.toString();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Winners other = (Winners) o;
        return Objects.equals(winners, other.winners);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winners);
    }
}

package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public Iterable<String> names() {
        return winners.stream()
                .map(Car::name)
                .toList();
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

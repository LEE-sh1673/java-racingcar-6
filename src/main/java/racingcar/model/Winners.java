package racingcar.model;

import java.util.List;

public class Winners {

    private final List<String> names;

    Winners(final List<Car> names) {
        this.names = names.stream()
                .map(Car::getName)
                .toList();
    }

    public List<String> getNames() {
        return names;
    }
}

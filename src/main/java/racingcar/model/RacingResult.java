package racingcar.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingResult {

    private final Map<String, Integer> positions;

    RacingResult(final List<Car> cars) {
        positions = makePositions(cars);
    }

    private Map<String, Integer> makePositions(final List<Car> cars) {
        final Map<String, Integer> positions = new HashMap<>();

        for (final Car car : cars) {
            positions.put(car.getName(), car.getPosition().intValue());
        }
        return positions;
    }

    public Map<String, Integer> getPositions() {
        return Collections.unmodifiableMap(positions);
    }
}

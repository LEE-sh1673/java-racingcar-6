package racingcar.view;

import java.util.StringJoiner;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Winners;

public class OutputView {

    private static final String RACING_RESULT_TITLE = "실행 결과";
    private static final String RACING_WINNERS_FORMAT = "최종 우승자 : %s";

    public void printCars(final Cars cars) {
        System.out.println(System.lineSeparator() + RACING_RESULT_TITLE);
        for (final Car car : cars.cars()) {
            System.out.printf("%s : %s", car.name(), "-".repeat(car.position()));
        }
        System.out.println();
    }

    public void printWinners(final Winners winners) {
        System.out.printf(RACING_WINNERS_FORMAT, formatNames(winners));
    }

    private String formatNames(final Winners winners) {
        final StringJoiner names = new StringJoiner(",");
        for (final String name : winners.names()) {
            names.add(name);
        }
        return names.toString();
    }
}

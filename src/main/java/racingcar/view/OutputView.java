package racingcar.view;

import java.util.List;

import racingcar.model.dto.CarDto;
import racingcar.model.dto.Winners;

public class OutputView {

    private static final String RACING_RESULT_TITLE = "실행 결과";
    private static final String RACING_RESULT_LINE_FORMAT = "%s : %s\n";
    private static final String RACING_SCORE_FORMAT = "-";
    private static final String RACING_WINNERS_FORMAT = "최종 우승자 : %s";
    private static final String RACING_WINNERS_NAME_DELIMITER = ", ";

    public void printCars(final List<CarDto> cars) {
        System.out.println(System.lineSeparator() + RACING_RESULT_TITLE);
        cars.forEach(this::printCar);
        System.out.println();
    }

    private void printCar(final CarDto car) {
        System.out.printf(RACING_RESULT_LINE_FORMAT,
            car.name(),
            RACING_SCORE_FORMAT.repeat(car.position())
        );
    }

    public void printWinners(final Winners winners) {
        System.out.printf(RACING_WINNERS_FORMAT, formatWinners(winners));
    }

    private String formatWinners(final Winners winners) {
        return String.join(RACING_WINNERS_NAME_DELIMITER, winners.names());
    }
}

package racingcar.view;

import racingcar.model.RacingResult;
import racingcar.model.Winners;

public class OutputView {

    private static final String RACING_RESULT_TITLE = "실행 결과";
    private static final String RACING_RESULT_LINE_FORMAT = "%s : %s\n";
    private static final String RACING_SCORE_FORMAT = "-";
    private static final String RACING_WINNERS_FORMAT = "최종 우승자 : %s";
    private static final String RACING_WINNERS_NAME_DELIMITER = ", ";

    public void printResult(final RacingResult racingResult) {
        System.out.println(System.lineSeparator() + RACING_RESULT_TITLE);
        racingResult.getPositions().forEach(this::printCar);
        System.out.println();
    }

    private void printCar(final String name, final int position) {
        System.out.printf(RACING_RESULT_LINE_FORMAT, name, RACING_SCORE_FORMAT.repeat(position));
    }

    public void printWinners(final Winners winners) {
        System.out.printf(RACING_WINNERS_FORMAT, formatWinners(winners));
    }

    private String formatWinners(final Winners winners) {
        return String.join(RACING_WINNERS_NAME_DELIMITER, winners.getNames());
    }
}

package racingcar.view;

import racingcar.model.RacingResult;
import racingcar.model.Winners;

public class OutputView {

    private static final String RACING_RESULT_TITLE = "실행 결과";
    private static final String RACING_WINNERS_FORMAT = "최종 우승자 : %s";

    public void printResult(final RacingResult result) {
        System.out.println(System.lineSeparator() + RACING_RESULT_TITLE);
        System.out.println(result.results());
        System.out.println();
    }

    public void printWinners(final Winners winners) {
        System.out.printf(RACING_WINNERS_FORMAT, winners.names());
    }
}

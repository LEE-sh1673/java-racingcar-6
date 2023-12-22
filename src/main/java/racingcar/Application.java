package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        final RacingGameController gameController = createController();
        gameController.run();
    }

    private static RacingGameController createController() {
        return new RacingGameController(new InputView(), new OutputView());
    }
}

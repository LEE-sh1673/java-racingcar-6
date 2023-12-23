package racingcar.controller;

import racingcar.model.MovingStrategy;
import racingcar.model.RacingGame;
import racingcar.model.RandomMovingStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingGameController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        final RacingGame game = new RacingGame(inputView.readCars(), inputView.readTryCount());
        final MovingStrategy movingStrategy = new RandomMovingStrategy();

        while (game.isRacing()) {
            game.race(movingStrategy);
            outputView.printResult(game.getResult());
        }
        outputView.printWinners(game.getWinners());
    }
}

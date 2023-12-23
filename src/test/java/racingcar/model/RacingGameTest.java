package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class RacingGameTest {

    @ParameterizedTest
    @MethodSource("generateCarNames")
    @DisplayName("모든 자동차가 움직이지 않은 경우 경주 이동한 거리는 0이다.")
    void isAllCarsStopped_Then_ZeroScoreReturns(final String names) {
        // given
        RacingGame racingGame = new RacingGame(Cars.withNames(names), TryCount.valueOf(1));

        // when
        racingGame.race(() -> false);
        final RacingResult racingResult = racingGame.getResult();

        // then
        final Cars stopped = Cars.withNames(names).move(() -> false);
        final RacingResult expected = new RacingResult();

        for (final Car car : stopped.cars()) {
            expected.report(car);
        }
        assertThat(expected).isEqualTo(racingResult);
    }

    @ParameterizedTest
    @MethodSource("generateCarNames")
    @DisplayName("모든 자동차가 동일한 속도로 경주한 경우 거리는 1이다.")
    void isAllCarsMoveForward_Then_OneScoreReturns(final String names) {
        // given
        RacingGame racingGame = new RacingGame(Cars.withNames(names), TryCount.valueOf(1));

        // when
        racingGame.race(() -> true);
        final RacingResult racingResult = racingGame.getResult();

        // then
        final Cars moved = Cars.withNames(names).move(() -> true);
        final RacingResult expected = new RacingResult();

        for (final Car car : moved.cars()) {
            expected.report(car);
        }
        assertThat(expected).isEqualTo(racingResult);
    }

    @ParameterizedTest
    @MethodSource("generateCarNames")
    @DisplayName("모든 자동차가 동일한 속도로 경주한 경우 모두 우승자이다.")
    void isAllCarsMoveForward_Then_AllWinnersReturns(final String names) {
        // given
        RacingGame racingGame = new RacingGame(Cars.withNames(names), TryCount.valueOf(1));

        // when
        racingGame.race(() -> true);
        final Winners winners = racingGame.getWinners();

        // then
        assertThat(winners.names()).isEqualTo(names);
    }

    private static Stream<Arguments> generateCarNames() {
        return Stream.of(
                Arguments.of("pobi,woni,jun"),
                Arguments.of("pribi,lsh,woni")
        );
    }
}

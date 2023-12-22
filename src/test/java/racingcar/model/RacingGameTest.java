package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class RacingGameTest {

    @ParameterizedTest
    @MethodSource("generateCarNames")
    @DisplayName("모든 자동차가 움직이지 않은 경우 경주 이동한 거리는 0이다.")
    void isAllCarsStopped_Then_ZeroScoreReturns(final List<String> names) {
        // given
        RacingGame racingGame = new RacingGame(Cars.withNames(names), TryCount.valueOf(1));

        // when
        racingGame.race(() -> false);
        RacingResult racingResult = racingGame.getResult();

        // then
        Map<String, Integer> positions = racingResult.getPositions();
        assertThat(positions.keySet()).contains(names.toArray(String[]::new));
        assertThat(positions.values()).containsOnly(0);
    }

    @ParameterizedTest
    @MethodSource("generateCarNames")
    @DisplayName("모든 자동차가 동일한 속도로 경주한 경우 거리는 1이다.")
    void isAllCarsMoveForward_Then_OneScoreReturns(final List<String> names) {
        // given
        RacingGame racingGame = new RacingGame(Cars.withNames(names), TryCount.valueOf(1));

        // when
        racingGame.race(() -> true);
        RacingResult racingResult = racingGame.getResult();

        // then
        Map<String, Integer> positions = racingResult.getPositions();
        assertThat(positions.keySet()).containsExactlyInAnyOrder(names.toArray(String[]::new));
        assertThat(positions.values()).containsOnly(1);
    }

    @ParameterizedTest
    @MethodSource("generateCarNames")
    @DisplayName("모든 자동차가 동일한 속도로 경주한 경우 모두 우승자이다.")
    void isAllCarsMoveForward_Then_AllWinnersReturns(final List<String> names) {
        // given
        RacingGame racingGame = new RacingGame(Cars.withNames(names), TryCount.valueOf(1));

        // when
        racingGame.race(() -> true);
        Winners winners = racingGame.getWinners();
        List<String> winnerNames = winners.getNames();

        // then
        assertThat(winnerNames.size()).isEqualTo(3);
        assertThat(winnerNames).containsExactly(names.toArray(String[]::new));
    }

    private static Stream<Arguments> generateCarNames() {
        return Stream.of(
                Arguments.of(List.of("pobi", "woni", "jun")),
                Arguments.of(List.of("pribi", "lsh", "woni"))
        );
    }
}

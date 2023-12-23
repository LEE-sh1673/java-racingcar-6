package racingcar.model;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import racingcar.model.dto.CarDto;
import racingcar.model.dto.Winners;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @ParameterizedTest
    @MethodSource("generateCarNames")
    @DisplayName("모든 자동차가 움직이지 않은 경우 경주 이동한 거리는 0이다.")
    void isAllCarsStopped_Then_ZeroScoreReturns(final List<String> names) {
        // given
        RacingGame racingGame = new RacingGame(Cars.withNames(names), TryCount.valueOf(1));

        // when
        racingGame.race(() -> false);
        List<CarDto> cars = racingGame.getCars();

        // then
        List<String> carNames = cars.stream().map(CarDto::name).toList();
        List<Integer> positions = cars.stream().map(CarDto::position).toList();

        assertThat(carNames.containsAll(names)).isTrue();
        assertThat(positions).containsOnly(0);
    }

    @ParameterizedTest
    @MethodSource("generateCarNames")
    @DisplayName("모든 자동차가 동일한 속도로 경주한 경우 거리는 1이다.")
    void isAllCarsMoveForward_Then_OneScoreReturns(final List<String> names) {
        // given
        RacingGame racingGame = new RacingGame(Cars.withNames(names), TryCount.valueOf(1));

        // when
        racingGame.race(() -> true);
        List<CarDto> cars = racingGame.getCars();

        // then
        List<String> carNames = cars.stream().map(CarDto::name).toList();
        List<Integer> positions = cars.stream().map(CarDto::position).toList();

        assertThat(carNames.containsAll(names)).isTrue();
        assertThat(positions).containsOnly(1);
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
        List<String> winnerNames = winners.names();

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

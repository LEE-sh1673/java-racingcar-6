package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("자동차를 정지시킨다.")
    void canNotMovable_Then_StopCar() {
        // given
        Car car = Car.withName("lsh");

        // when
        Car moved = car.move(() -> false);

        // then
        assertThat(moved.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차를 이동시킨다.")
    void canMovable_Then_MoveCar() {
        // given
        Car car = Car.withName("lsh");

        // when
        Car moved = car.move(() -> true);

        // then
        assertThat(moved.getPosition()).isEqualTo(1);
    }
}

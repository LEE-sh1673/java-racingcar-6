package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    @DisplayName("자동차를 정지시킨다.")
    void canNotMovable_Then_StopCar() {
        Car car = Car.withName("lsh");
        car.move(() -> false);
        assertThat(car.getPosition().intValue()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차를 이동시킨다.")
    void canMovable_Then_MoveCar() {
        Car car = Car.withName("lsh");
        car.move(() -> true);
        assertThat(car.getPosition().intValue()).isEqualTo(1);
    }
}

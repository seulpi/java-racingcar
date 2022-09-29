package game.domain;

import game.domain.car.RacingGameCar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class RacingGameCarTest {

    private RacingGameCar car;

    @BeforeEach
    private void setCar() {
        car = new RacingGameCar("name");
    }

    @ParameterizedTest(name = "자동차의 위치를 숫자만큼 증가시킨다")
    @ValueSource(ints = {1, 33, 999})
    void forward(int number) {
        int expected = car.location() + number;

        car.forward(number);

        assertThat(car.location()).isEqualTo(expected);
    }

    @DisplayName("자동차 이름을 부여한다 자동차 이름은 5자를 초과할 수 없다.")
    @Test
    void checkNameLength() {
        Assertions.assertAll(
                () -> assertThat(new RacingGameCar("name").name()).isEqualTo("name"),
                () -> assertThatThrownBy(() -> new RacingGameCar("overLength")).isInstanceOf(RuntimeException.class)
        );
    }

}

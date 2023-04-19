package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @ParameterizedTest
    @DisplayName("전진하는 조건을 규칙에 맞게 생성할 수 있다.")
    @CsvSource(value = {"0:false", "3:false", "4:true", "9:true"}, delimiter = ':')
    public void judgeForth_rule_makeSuccess(int input, boolean expected) {
        Car car = new Car();

        assertThat(car.judgeForth(input)).isEqualTo(expected);
    }

    @DisplayName("이동거리만큼 이동할 수 있다.")
    @Test
    public void move_distance_togo() {
        Car car = new Car();

        car.move(new MovableRandomValueGenerator());
        car.move(new MovableRandomValueGenerator());
        car.move(new NonMovableRandomValueGenerator());

        assertThat(car.showNowPosition()).isEqualTo(2);
    }

    @DisplayName("숫자가 4보다 크먄 위치를 1칸 이동")
    @Test
    public void move_NumberIsEqualOrGreaterThanFour_GoPositionForOne() {
        RandomValueGenerator randomValue = new MovableRandomValueGenerator();
        Car car = new Car();

        car.move(randomValue);
        assertThat(car.showNowPosition()).isEqualTo(1);
    }

    @DisplayName("숫자가 4보다 작으면 위치를 그대로 유지")
    @Test
    public void move_NumberisLessThanFour_KeepPosition() {
        RandomValueGenerator randomValue = new NonMovableRandomValueGenerator();
        Car car = new Car();

        car.move(randomValue);
        assertThat(car.showNowPosition()).isEqualTo(0);
    }

}
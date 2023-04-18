package com.nextstep.racingcargame.core;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    private static final String TEST_CAR_NAME = "test";

    private static final int STOP_NUMBER = 3;

    private static final int MOVE_NUMBER = 4;

    private static final int MOVE_STEP = 1;

    private static final int CAR_START_POSITION_NUMBER = 0;

    private Car basePositionedCar;

    @BeforeEach
    void setUp() {
        basePositionedCar = new Car(new Name(TEST_CAR_NAME), new Distance(CAR_START_POSITION_NUMBER));
    }

    @Test
    @DisplayName("Equals And Hash Code 구현에 따라 Car 객체에 동일한 값이 주입되어 생성된 경우 서로 같은 해시값을 갖는다")
    void equalsAndHashCodeTest() {
        Car group_one = new Car(new Name(TEST_CAR_NAME), new Distance(0));
        Car group_two = new Car(new Name(TEST_CAR_NAME), new Distance(0));
        assertThat(group_one.equals(group_two)).isTrue();
    }

    @Test
    @DisplayName("랜덤으로 발생한 숫자가 3 이하일경우 차량은 정지상태를 유지한다")
    void carStopTest() {
        basePositionedCar.move(new Stop());
        assertThat(basePositionedCar).isEqualTo(new Car(new Name(TEST_CAR_NAME), new Distance(CAR_START_POSITION_NUMBER)));
    }

    @Test
    @DisplayName("랜덤으로 발생한 숫자가 4 이상일 경우 차량은 한칸 앞으로 움직인다.")
    void moveTest() {
        basePositionedCar.move(new ForceMove());
        assertThat(basePositionedCar).isEqualTo(new Car(new Name(TEST_CAR_NAME), new Distance(MOVE_STEP)));
    }

    private static class ForceMove implements MovingStrategy {

        @Override
        public int randomNumber() {
            return MOVE_NUMBER;
        }
    }

    private static class Stop implements MovingStrategy {

        @Override
        public int randomNumber() {
            return STOP_NUMBER;
        }
    }
}
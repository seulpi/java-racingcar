package racing;

import racing.domain.Car;
import racing.domain.Cars;
import racing.domain.TryCount;
import racing.view.InputView;
import racing.view.ResultView;
import racing.domain.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private final InputView inputView;
    private final MoveStrategy moveStrategy;

    private static final String CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).\n";
    private static final String TRY_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";

    public Race(InputView inputView, MoveStrategy moveStrategy) {
        this.inputView = inputView;
        this.moveStrategy = moveStrategy;
    }

    public void start() {
        List<String> carNames = inputView.inputtedCarNameList(CAR_NAME_MESSAGE);
        TryCount tryCount = TryCount.valueOf(inputView.inputtedNumber(TRY_COUNT_MESSAGE));
        inputView.closeScanner();

        List<Car> cars = new ArrayList<>();

        for (String carName : carNames) {
            cars.add(Car.from(carName));
        }

        Cars racingCars = Cars.from(cars);

        ResultView resultView = new ResultView();

        while (tryCount.hasLeft()) {
            tryCount.decrement();
            playRound(racingCars);
            resultView.printRaceResult(racingCars);
        }

        resultView.printRaceWinner(racingCars);
    }

    private void playRound(Cars cars) {
        for (Car car : cars) {
            car.play(moveStrategy);
        }
    }
}

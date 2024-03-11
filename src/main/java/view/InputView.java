package view;

import java.util.List;
import java.util.Scanner;

import util.NameSplitter;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public List<String> inputRacingCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return NameSplitter.split(SCANNER.nextLine());
    }

    public int inputTryNumber() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return SCANNER.nextInt();
    }
}

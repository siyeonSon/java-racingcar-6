package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Stream;
import racingcar.model.Car;
import racingcar.model.Cars;

public class InputView {
    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String DELIMITER = ",";

    public Cars readCarName() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
        String input = Console.readLine();
        List<Car> cars = parseCarList(input);
        return new Cars(cars);
    }

    private List<Car> parseCarList(String carNames) {
        return Stream.of(carNames.split(DELIMITER))
                .map(Car::new)
                .toList();
    }

    public int readCount() {
        System.out.println(INPUT_COUNT_MESSAGE);
        String input = Console.readLine();
        System.out.println();
        return Integer.parseInt(input);
    }
}

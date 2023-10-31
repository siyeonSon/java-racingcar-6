package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {
    private static final String DELIMITER = ",";
    private static final String SINGLE_BLANK = " ";
    private static final String COLON = ":";
    private static final String HYPHEN = "-";
    private static final String NEWLINE = "\n";

    private final List<Car> cars;

    public Cars(String carNames) {
        cars = stringToCarList(carNames);
    }

    private List<Car> stringToCarList(String carNames) {
        return Stream.of(carNames.split(DELIMITER))
                .map(Car::new)
                .toList();
    }

    public void forward() {
        cars.forEach(Car::forward);
    }

    public String result() {
        return cars.stream()
                .map(this::formatCarInfo)
                .collect(Collectors.joining(NEWLINE));
    }

    private String formatCarInfo(Car car) {
        return car.getName() + SINGLE_BLANK + COLON + SINGLE_BLANK + HYPHEN.repeat(car.getPoint());
    }

    public String judgeWinner() {
        int maxPoint = findMaxPoint();
        return cars.stream()
                .filter(car -> car.getPoint() == maxPoint)
                .map(Car::getName)
                .collect(Collectors.joining(DELIMITER+SINGLE_BLANK));
    }

    private int findMaxPoint() {
        return cars.stream()
                .mapToInt(Car::getPoint)
                .max()
                .orElse(0);
    }
}

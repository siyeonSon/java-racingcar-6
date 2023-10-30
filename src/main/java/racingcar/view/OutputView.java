package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.model.Referee;

public class OutputView {
    private static final String GAME_RESULT = "실행 결과";
    private static final String WINNER = "최종 우승자 : ";

    public void play(List<Car> cars, int count) {
        System.out.println(GAME_RESULT);
        for (int i = 0; i < count; i++) {
            cars.forEach(Car::forward);
            System.out.println();
        }
    }

    public void printWinner(List<Car> cars) {
        List<Car> winners = Referee.getWinner(cars);
        System.out.print(WINNER);
        System.out.println(extractWinnerName(winners));
    }

    private String extractWinnerName(List<Car> winners) {
        return winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }
}

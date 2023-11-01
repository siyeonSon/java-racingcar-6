package racingcar.controller;

import racingcar.model.Cars;
import racingcar.util.NumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Game {
    private final InputView inputView;
    private final OutputView outputView;
    private final NumberGenerator numberGenerator;

    public Game(InputView inputView, OutputView outputView, NumberGenerator numberGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.numberGenerator = numberGenerator;
    }

    public void play() {
        Cars cars = inputView.inputCarName();
        int count = inputView.inputCount();

        outputView.printResultGuide();
        for (int i = 0; i < count; i++) {
            cars.forward(numberGenerator);
            outputView.printResult(cars);
        }
        outputView.printWinner(cars);
    }
}

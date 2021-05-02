package racing;

import java.util.List;

public interface RacingGamePrintable {

	void printCar(Car car);

	void printCars(Cars cars);

	void printWinners(List<Car> winners);

	void printResult(RacingGameResult result);

	void printEmptyLine();
}

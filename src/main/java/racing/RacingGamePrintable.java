package racing;

import java.util.List;

public interface RacingGamePrintable {

	void printCar(Car car);

	void printResult(List<Car> carList);

	void printWinners(List<Car> winners);

	void printEmptyLine();
}

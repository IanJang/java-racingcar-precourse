package racing;

import java.util.ArrayList;
import java.util.List;

public class RacingGameStandardPrinter implements RacingGamePrintable {
	private static final String CAR_NAME_SEPARATOR = ",";
	private static final String PRINT_CAR_MESSAGE_TEMPLATE = "%s : %s%n";
	private static final String PRINT_WINNERS_MESSAGE_TEMPLATE = "%s가 최종 우승했습니다.%n";

	@Override
	public void printCar(Car car) {
		StringBuilder positionString = new StringBuilder();
		for (int i = 0; i < car.getPosition(); i++) {
			positionString.append("_");
		}
		System.out.printf(PRINT_CAR_MESSAGE_TEMPLATE, car.getName(), positionString);
	}

	@Override
	public void printCars(Cars cars) {
		for (Car car : cars.getCarList()) {
			printCar(car);
		}
		printEmptyLine();
	}

	@Override
	public void printWinners(List<Car> winners) {
		List<String> winnerNames = new ArrayList<>();
		for (Car car : winners) {
			winnerNames.add(car.getName());
		}
		System.out.printf(PRINT_WINNERS_MESSAGE_TEMPLATE, String.join(CAR_NAME_SEPARATOR, winnerNames));
	}

	@Override
	public void printEmptyLine() {
		System.out.println();
	}
}

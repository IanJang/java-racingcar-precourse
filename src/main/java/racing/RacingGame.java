package racing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RacingGame {
	private static final int MIN_DICE_NUMBER_TO_MOVE = 4;
	private static final String CAR_NAME_SEPARATOR = ",";
	private static final String PRINT_CAR_MESSAGE_TEMPLATE = "%s : %s%n";
	private static final String PRINT_WINNERS_MESSAGE_TEMPLATE = "%s가 최종 우승했습니다.%n";
	private final RacingGameDice dice;
	private final Cars cars;

	public RacingGame(Cars cars) {
		this.cars = cars;
		this.dice = new RacingGameDice();
	}

	public void playTurn(int carIndex, int diceNumber) {
		Car car = cars.getCarList().get(carIndex);
		if (diceNumber >= MIN_DICE_NUMBER_TO_MOVE) {
			car.moveForward();
		}
	}

	public void playRound() {
		List<Car> carList = cars.getCarList();
		for (int i = 0; i < carList.size(); i++) {
			int diceNumber = dice.roll();
			playTurn(i, diceNumber);
		}
	}

	public void playMultipleRounds(int count) {
		for (int i = 0; i < count; i++) {
			playRound();
		}
	}

	public List<Car> sortedCarList() {
		return cars.sortedCarList();
	}

	public List<Car> getWinners() {
		int maxPosition = sortedCarList().get(0).getPosition();
		HashMap<Integer, List<Car>> positionMap = new HashMap<>();
		for (Car car : cars.getCarList()) {
			int position = car.getPosition();
			List<Car> carList = positionMap.get(position);
			carList = carList != null ? carList : new ArrayList<>();
			carList.add(car);
			positionMap.put(car.getPosition(), carList);
		}
		return positionMap.get(maxPosition);
	}

	public void printCar(Car car) {
		StringBuilder positionString = new StringBuilder();
		for (int i = 0; i < car.getPosition(); i++) {
			positionString.append("_");
		}
		System.out.printf(PRINT_CAR_MESSAGE_TEMPLATE, car.getName(), positionString);
	}

	public void printResult() {
		for (Car car : cars.getCarList()) {
			printCar(car);
		}
		System.out.println();
	}

	public void printWinners() {
		List<String> winnerNames = new ArrayList<>();
		for (Car car : getWinners()) {
			winnerNames.add(car.getName());
		}
		System.out.printf(PRINT_WINNERS_MESSAGE_TEMPLATE, String.join(CAR_NAME_SEPARATOR, winnerNames));
	}
}

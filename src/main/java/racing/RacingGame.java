package racing;

import java.util.List;

public class RacingGame {
	private static final int MIN_DICE_NUMBER_TO_MOVE = 4;
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
}

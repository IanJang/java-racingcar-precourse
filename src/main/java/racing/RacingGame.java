package racing;

public class RacingGame {
	private static final int MIN_DICE_NUMBER_TO_MOVE = 4;
	private final Cars cars;

	public RacingGame(Cars cars) {
		this.cars = cars;
	}

	public void playTurn(int carIndex, int diceNumber) {
		Car car = cars.getCarList().get(carIndex);
		if (diceNumber >= MIN_DICE_NUMBER_TO_MOVE) {
			car.moveForward();
		}
	}
}

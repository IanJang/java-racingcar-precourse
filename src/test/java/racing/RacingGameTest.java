package racing;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RacingGameTest {
	private Cars cars;
	private List<Car> carList;
	private RacingGame game;

	@BeforeEach
	void setUp() {
		cars = new Cars("pobi,crong,honux");
		carList = cars.getCarList();
		game = new RacingGame(cars);
	}

	@Test
	void playTurn() {
		Car pobi = carList.get(0);
		game.playTurn(0, 0);
		assertThat(pobi.getPosition()).isEqualTo(0);
		game.playTurn(0, 3);
		assertThat(pobi.getPosition()).isEqualTo(0);
		game.playTurn(0, 4);
		assertThat(pobi.getPosition()).isEqualTo(1);
		game.playTurn(0, 9);
		assertThat(pobi.getPosition()).isEqualTo(2);
	}

	@Test
	void playRound() {
		game.playRound();
		for (Car car : carList) {
			assertThat(car.getPosition())
				.isGreaterThanOrEqualTo(0)
				.isLessThanOrEqualTo(1);
		}
	}

	@Test
	void playMultipleRounds() {
		game.playMultipleRounds(5);
		for (Car car : carList) {
			assertThat(car.getPosition())
				.isGreaterThanOrEqualTo(0)
				.isLessThanOrEqualTo(5);
		}
	}
}

package racing;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

public class RacingGameTest {

	@Test
	void playTurn() {
		Cars cars = new Cars("pobi,crong,honux");
		List<Car> carList = cars.getCarList();
		Car pobi = carList.get(0);
		RacingGame game = new RacingGame(cars);
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
		Cars cars = new Cars("pobi,crong,honux");
		List<Car> carList = cars.getCarList();
		RacingGame game = new RacingGame(cars);
		game.playRound();
		for (Car car : carList) {
			assertThat(car.getPosition())
				.isGreaterThanOrEqualTo(0)
				.isLessThanOrEqualTo(1);
		}
	}
}

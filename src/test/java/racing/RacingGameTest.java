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

	@Test
	void sortedCarList() {
		Car pobi = carList.get(0);
		Car crong = carList.get(1);
		Car honux = carList.get(2);

		crong.moveForward();
		crong.moveForward();
		honux.moveForward();

		List<Car> sortedCarList = game.sortedCarList();
		assertThat(sortedCarList.get(0)).isEqualTo(crong);
		assertThat(sortedCarList.get(1)).isEqualTo(honux);
		assertThat(sortedCarList.get(2)).isEqualTo(pobi);

		// sortedCarList 호출 후에도 기존 CarList의 순서는 유지
		assertThat(carList.get(0)).isEqualTo(pobi);
		assertThat(carList.get(1)).isEqualTo(crong);
		assertThat(carList.get(2)).isEqualTo(honux);
	}

	@Test
	void getWinners_OneWinner() {
		Car crong = carList.get(1);
		crong.moveForward();

		assertThat(game.getWinners()).containsExactly(crong);
	}

	@Test
	void getWinners_twoWinners() {
		Car crong = carList.get(1);
		Car honux = carList.get(2);
		crong.moveForward();
		honux.moveForward();

		assertThat(game.getWinners())
			.hasSize(2)
			.containsOnlyOnce(crong)
			.containsOnlyOnce(honux);
	}

	@Test
	void getWinners_threeWinners() {
		assertThat(game.getWinners())
			.hasSize(3)
			.containsAll(carList);
	}
}

package racing;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.RepeatedTest;

public class RacingGameDiceTest {

	@RepeatedTest(10)
	void roll() {
		RacingGameDice dice = new RacingGameDice();
		assertThat(dice.roll())
			.isInstanceOf(Integer.class)
			.isGreaterThanOrEqualTo(0)
			.isLessThanOrEqualTo(9);
	}
}

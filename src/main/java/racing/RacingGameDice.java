package racing;

import java.util.Random;

public class RacingGameDice {
	private static final int MAX_NUMBER = 9;

	public int roll() {
		Random rand = new Random();
		return rand.nextInt(MAX_NUMBER);
	}
}

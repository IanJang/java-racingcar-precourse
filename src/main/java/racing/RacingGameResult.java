package racing;

import java.util.ArrayList;
import java.util.List;

public class RacingGameResult {
	private final List<Cars> gameResult;

	public RacingGameResult() {
		gameResult = new ArrayList<>();
	}

	public void report(Cars roundResult) {
		gameResult.add(roundResult);
	}

	public List<Cars> getGameResult() {
		return gameResult;
	}
}

package main;

import java.util.Scanner;

import racing.Cars;
import racing.RacingGame;

public class Main {
	public static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	public static final String ROUND_COUNT_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
	public static final String PLAY_RESULT_OUTPUT_MESSAGE = "실행 결과";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println(CAR_NAME_INPUT_MESSAGE);
		String carNamesString = sc.next();
		RacingGame game = new RacingGame(new Cars(carNamesString));

		System.out.println(ROUND_COUNT_INPUT_MESSAGE);
		int roundCount = sc.nextInt();

		System.out.println(PLAY_RESULT_OUTPUT_MESSAGE);
		for (int i = 0; i < roundCount; i++) {
			game.playRound();
			game.printResult();
		}
		game.printWinners();
	}
}

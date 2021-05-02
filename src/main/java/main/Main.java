package main;

import java.util.Scanner;

import racing.Cars;
import racing.RacingGame;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String carNamesString = sc.next();
		RacingGame game = new RacingGame(new Cars(carNamesString));

		System.out.println("시도할 회수는 몇회인가요?");
		int roundCount = sc.nextInt();

		System.out.println("실행 결과");
		for (int i = 0; i < roundCount; i++) {
			game.playRound();
			game.printResult();
		}
		game.printWinners();
	}
}

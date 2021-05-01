package racing;

import java.util.ArrayList;
import java.util.List;

public class Cars {
	private final List<Car> carList;

	public Cars(String carNamesString) {
		carList = new ArrayList<>();
		String[] carNames = carNamesString.split(",");
		for (String carName : carNames) {
			Car car = new Car(carName);
			carList.add(car);
		}
	}

	public List<Car> getCarList() {
		return carList;
	}
}

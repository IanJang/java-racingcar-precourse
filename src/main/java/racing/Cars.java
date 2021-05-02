package racing;

import java.util.ArrayList;
import java.util.Comparator;
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

	public List<Car> sortedCarList() {
		List<Car> sortedCarList = new ArrayList<>(carList);
		sortedCarList.sort(Comparator.comparingInt(Car::getPosition).reversed());
		return sortedCarList;
	}
}

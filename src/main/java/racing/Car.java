package racing;

public class Car {
	private final CarName carName;
	private final CarPosition carPosition;

	public Car(String name) {
		this.carName = new CarName(name);
		this.carPosition = new CarPosition(0);
	}

	public String getName() {
		return carName.getName();
	}

	public int getPosition() {
		return carPosition.getPosition();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Car car = (Car)obj;
		return this.carName.equals(car.carName)
			&& this.carPosition.equals(car.carPosition);
	}

	public void moveForward() {
		this.carPosition.increasePosition();
	}
}

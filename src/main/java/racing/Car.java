package racing;

public class Car {

    private final CarName carName;
    private final int position;

    public Car(String name) {
        this.carName = new CarName(name);
        this.position = 0;
    }

    public String getName() {
        return carName.getName();
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Car car = (Car) obj;
        return this.carName.equals(car.carName)
            && this.position == car.position;
    }
}

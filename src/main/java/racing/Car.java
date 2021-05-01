package racing;

public class Car {

    private final CarName carName;

    public Car(String name) {
        this.carName = new CarName(name);
    }

    public String getName() {
        return carName.getName();
    }
}

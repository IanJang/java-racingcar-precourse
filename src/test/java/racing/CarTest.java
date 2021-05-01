package racing;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void car() {
        Car car = new Car("pobi");
        assertThat(car).isInstanceOf(Car.class);
    }

    @Test
    void getName() {
        Car car = new Car("tico");
        assertThat(car.getName()).isEqualTo("tico");
    }

    @Test
    void getPosition() {
        Car car = new Car("audi");
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void equals() {
        assertThat(new Car("tico").equals(new Car("tico"))).isTrue();
        assertThat(new Car("tico").equals(new Car("audi"))).isFalse();
    }

    @Test
    void moveForward() {
        Car car = new Car("audi");
        assertThat(car.getPosition()).isEqualTo(0);
        car.moveForward();
        assertThat(car.getPosition()).isEqualTo(1);
        car.moveForward();
        assertThat(car.getPosition()).isEqualTo(2);
    }
}

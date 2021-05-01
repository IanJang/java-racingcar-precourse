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
}

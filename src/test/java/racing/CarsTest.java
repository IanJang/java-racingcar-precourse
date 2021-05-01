package racing;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

public class CarsTest {

	@Test
	void cars() {
		Cars cars = new Cars("tico,benz,audi,tesla");
		List<Car> carList = cars.getCarList();
		assertThat(carList).hasSize(4);
		assertThat(carList.get(0).equals(new Car("tico"))).isTrue();
		assertThat(carList.get(1).equals(new Car("benz"))).isTrue();
		assertThat(carList.get(2).equals(new Car("audi"))).isTrue();
		assertThat(carList.get(3).equals(new Car("tesla"))).isTrue();
	}
}

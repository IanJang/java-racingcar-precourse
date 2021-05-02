package racing;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CarPositionTest {

	@Test
	void carPosition_negativeInt() {
		assertThatThrownBy(() -> new CarPosition(-1))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageMatching("위치값은 0 이상의 자연수만 가능합니다.");
	}

	@Test
	void getPosition() {
		CarPosition carPosition = new CarPosition(1);
		assertThat(carPosition.getPosition()).isEqualTo(1);
	}

	@Test
	void equals() {
		assertThat(new CarPosition(1).equals(new CarPosition(1))).isTrue();
		assertThat(new CarPosition(0).equals(new CarPosition(1))).isFalse();
	}
}

package racing;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CarNameTest {

    @Test
    void carName_length0() {
        assertThatThrownBy(() -> new CarName(""))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageMatching("이름의 길이는 1~5자만 가능합니다.");
    }

    @Test
    void carName_length1() {
        CarName carName = new CarName("c");
        assertThat(carName.getName()).isEqualTo("c");
    }

    @Test
    void carName_length5() {
        CarName carName = new CarName("tesla");
        assertThat(carName.getName()).isEqualTo("tesla");
    }

    @Test
    void carName_length6() {
        assertThatThrownBy(() -> new CarName("sonata"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageMatching("이름의 길이는 1~5자만 가능합니다.");
    }
}

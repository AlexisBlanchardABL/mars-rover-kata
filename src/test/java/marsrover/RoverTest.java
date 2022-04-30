package marsrover;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class RoverTest {

    @Test
    void shouldFail() {
        assertThat("toto").isEqualTo("tutu");
    }

}

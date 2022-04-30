package marsrover;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class RoverTest {

    @Test
    void shouldInitializeARoverWithItsCoordinatesAndDirection() {
        int x = 2;
        int y = 7;
        char direction = 'N';
        Rover rover = new Rover(x, y, direction);
        assertThat(rover.getX()).isEqualTo(x);
        assertThat(rover.getY()).isEqualTo(y);
        assertThat(rover.getDirection()).isEqualTo(direction);
    }

}

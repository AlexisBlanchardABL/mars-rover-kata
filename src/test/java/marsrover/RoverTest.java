package marsrover;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static marsrover.DataSet.*;
import static org.assertj.core.api.Assertions.assertThat;


public class RoverTest {

    @ParameterizedTest
    @EnumSource(Direction.class)
    void shouldInitializeARoverWithItsPositionAndDirection(Direction direction) {
        Coordinates position = someCoordinates();
        Rover rover = aRover(position, direction);
        assertThat(rover.getPosition()).isEqualTo(position);
        assertThat(rover.getDirection()).isEqualTo(direction);
    }

}

package marsrover;

import org.junit.jupiter.api.Test;

import static marsrover.DataSet.aRover;
import static marsrover.DataSet.coordinates;
import static org.assertj.core.api.Assertions.assertThat;

public class ComplexRoverCommandsTest {

    @Test
    void roverMovesAndRotateMultipleTimes() {
        Rover rover = aRover(coordinates(0, 0), Direction.WEST);
        rover.execute('r', 'f', 'r', 'f', 'r', 'b');
        assertThat(rover.getPosition()).isEqualTo(coordinates(1, 2));
    }

    @Test
    void shouldIgnoreUnknownCommands() {
        Coordinates roverPosition = coordinates(4, 8);
        Direction roverDirection = Direction.WEST;
        Rover rover = aRover(mars(), roverPosition, roverDirection);
        rover.execute('#', 'w', 'x', '~');
        assertThat(rover.getPosition()).isEqualTo(roverPosition);
        assertThat(rover.getDirection()).isEqualTo(roverDirection);
    }

}

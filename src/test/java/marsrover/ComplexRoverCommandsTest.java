package marsrover;

import org.junit.jupiter.api.Test;

import java.util.List;

import static marsrover.DataSet.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ComplexRoverCommandsTest {

    @Test
    void roverMovesAndRotateMultipleTimes() {
        Rover rover = aRover(mars(), coordinates(5, 5), Direction.WEST);
        rover.execute('r', 'f', 'r', 'f', 'r', 'b');
        assertThat(rover.getPosition()).isEqualTo(coordinates(6, 7));
    }

    @Test
    void roverMovesTowardAnObstacleOnFirstCommandAndAbortSequence() {
        Coordinates roverPosition = coordinates(10, 10);
        Rover rover = aRover(marsWithObstacles(List.of(new Coordinates(10, 11))), roverPosition, Direction.NORTH);
        rover.execute('f', 'b', 'b', 'l', 'l', 'f');
        assertThat(rover.getPosition()).isEqualTo(roverPosition);
    }

    @Test
    void roverMovesTowardAnThroughWrappingEdgeCase() {
        Coordinates roverPosition = coordinates(20, 3);
        Rover rover = aRover(marsWithObstacles(List.of(new Coordinates(1, 3))), roverPosition, Direction.WEST);
        rover.execute('b');
        assertThat(rover.getPosition()).isEqualTo(roverPosition);
        assertThat(rover.getReport()).isEqualTo("An obstacle was found on Coordinates: 1, 3");
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

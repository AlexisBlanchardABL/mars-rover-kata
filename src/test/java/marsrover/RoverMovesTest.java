package marsrover;

import org.junit.jupiter.api.Test;

import static marsrover.DataSet.aRover;
import static marsrover.DataSet.coordinates;
import static org.assertj.core.api.Assertions.assertThat;

public class RoverMovesTest {

    @Test
    void roverMovesForwardOnceTowardNorth() {
        Rover rover = aRover(coordinates(1, 2), Direction.NORTH);
        rover.execute('f');
        assertThat(rover.getPosition()).isEqualTo(coordinates(1, 3));
    }

    @Test
    void roverMovesForwardOnceTowardEast() {
        Rover rover = aRover(coordinates(1, 2), Direction.EAST);
        rover.execute('f');
        assertThat(rover.getPosition()).isEqualTo(coordinates(2, 2));
    }

    @Test
    void roverMovesForwardTowardSouth() {
        Rover rover = aRover(coordinates(1, 2), Direction.SOUTH);
        rover.execute('f');
        assertThat(rover.getPosition()).isEqualTo(coordinates(1, 1));
    }

    @Test
    void roverMovesForwardTowardWest() {
        Rover rover = aRover(coordinates(1, 2), Direction.WEST);
        rover.execute('f');
        assertThat(rover.getPosition()).isEqualTo(coordinates(0, 2));
    }

}

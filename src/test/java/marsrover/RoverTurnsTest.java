package marsrover;

import org.junit.jupiter.api.Test;

import static marsrover.DataSet.aRover;
import static marsrover.DataSet.coordinates;
import static org.assertj.core.api.Assertions.assertThat;

public class RoverTurnsTest {

    @Test
    void roverFacingNorthTurningRight_shouldFaceEast() {
        Rover rover = aRover(coordinates(1, 2), Direction.N);
        rover.execute('r');
        assertThat(rover.getDirection()).isEqualTo(Direction.E);
    }

    @Test
    void roverFacingEastTurningRight_shouldFaceSouth() {
        Rover rover = aRover(coordinates(1, 2), Direction.E);
        rover.execute('r');
        assertThat(rover.getDirection()).isEqualTo(Direction.S);
    }

    @Test
    void roverFacingSouthTurningRight_shouldFaceWest() {
        Rover rover = aRover(coordinates(1, 2), Direction.S);
        rover.execute('r');
        assertThat(rover.getDirection()).isEqualTo(Direction.W);
    }

    @Test
    void roverFacingWestTurningRight_shouldFaceNorth() {
        Rover rover = aRover(coordinates(1, 2), Direction.W);
        rover.execute('r');
        assertThat(rover.getDirection()).isEqualTo(Direction.N);
    }

}

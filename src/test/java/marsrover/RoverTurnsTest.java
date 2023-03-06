package marsrover;

import org.junit.jupiter.api.Test;

import static marsrover.DataSet.*;
import static org.assertj.core.api.Assertions.assertThat;

public class RoverTurnsTest {

    @Test
    void roverFacingNorthTurningRight_shouldFaceEast() {
        Rover rover = aRover(mars(), position(1, 2), Direction.NORTH);
        rover.execute('r');
        assertThat(rover.getDirection()).isEqualTo(Direction.EAST);
    }

    @Test
    void roverFacingEastTurningRight_shouldFaceSouth() {
        Rover rover = aRover(mars(), position(1, 2), Direction.EAST);
        rover.execute('r');
        assertThat(rover.getDirection()).isEqualTo(Direction.SOUTH);
    }

    @Test
    void roverFacingSouthTurningRight_shouldFaceWest() {
        Rover rover = aRover(mars(), position(1, 2), Direction.SOUTH);
        rover.execute('r');
        assertThat(rover.getDirection()).isEqualTo(Direction.WEST);
    }

    @Test
    void roverFacingWestTurningRight_shouldFaceNorth() {
        Rover rover = aRover(mars(), position(1, 2), Direction.WEST);
        rover.execute('r');
        assertThat(rover.getDirection()).isEqualTo(Direction.NORTH);
    }

    @Test
    void roverFacingNorthTurningLeft_shouldFaceWest() {
        Rover rover = aRover(mars(), position(1, 2), Direction.NORTH);
        rover.execute('l');
        assertThat(rover.getDirection()).isEqualTo(Direction.WEST);
    }

    @Test
    void roverFacingEastTurningLeft_shouldFaceNorth() {
        Rover rover = aRover(mars(), position(1, 2), Direction.EAST);
        rover.execute('l');
        assertThat(rover.getDirection()).isEqualTo(Direction.NORTH);
    }

    @Test
    void roverFacingSouthTurningLeft_shouldFaceEast() {
        Rover rover = aRover(mars(), position(1, 2), Direction.SOUTH);
        rover.execute('l');
        assertThat(rover.getDirection()).isEqualTo(Direction.EAST);
    }

    @Test
    void roverFacingWestTurningLeft_shouldFaceSouth() {
        Rover rover = aRover(mars(), position(1, 2), Direction.WEST);
        rover.execute('l');
        assertThat(rover.getDirection()).isEqualTo(Direction.SOUTH);
    }

    @Test
    void roversPositionDoNotChangeWhenTurning() {
        Position position = position(1, 2);
        Rover rover = aRover(mars(), position, Direction.WEST);
        rover.execute('l');
        assertThat(rover.getPosition()).isEqualTo(position);
    }

    @Test
    void roversTurningMultipleTimes() {
        Position position = position(1, 2);
        Rover rover = aRover(mars(), position, Direction.NORTH);
        rover.execute('l', 'l', 'r', 'l');
        assertThat(rover.getDirection()).isEqualTo(Direction.SOUTH);
    }

}

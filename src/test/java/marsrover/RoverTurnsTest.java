package marsrover;

import org.junit.jupiter.api.Test;

import static marsrover.DataSet.aRover;
import static marsrover.DataSet.coordinates;
import static org.assertj.core.api.Assertions.assertThat;

public class RoverTurnsTest {

    @Test
    void roverFacingNorthTurningRight_shouldFaceEast() {
        Rover rover = aRover(coordinates(1, 2), Direction.NORTH);
        rover.execute('r');
        assertThat(rover.getDirection()).isEqualTo(Direction.EAST);
    }

    @Test
    void roverFacingEastTurningRight_shouldFaceSouth() {
        Rover rover = aRover(coordinates(1, 2), Direction.EAST);
        rover.execute('r');
        assertThat(rover.getDirection()).isEqualTo(Direction.SOUTH);
    }

    @Test
    void roverFacingSouthTurningRight_shouldFaceWest() {
        Rover rover = aRover(coordinates(1, 2), Direction.SOUTH);
        rover.execute('r');
        assertThat(rover.getDirection()).isEqualTo(Direction.WEST);
    }

    @Test
    void roverFacingWestTurningRight_shouldFaceNorth() {
        Rover rover = aRover(coordinates(1, 2), Direction.WEST);
        rover.execute('r');
        assertThat(rover.getDirection()).isEqualTo(Direction.NORTH);
    }

    @Test
    void roverFacingNorthTurningLeft_shouldFaceWest() {
        Rover rover = aRover(coordinates(1, 2), Direction.NORTH);
        rover.execute('l');
        assertThat(rover.getDirection()).isEqualTo(Direction.WEST);
    }

    @Test
    void roverFacingEastTurningLeft_shouldFaceNorth() {
        Rover rover = aRover(coordinates(1, 2), Direction.EAST);
        rover.execute('l');
        assertThat(rover.getDirection()).isEqualTo(Direction.NORTH);
    }

    @Test
    void roverFacingSouthTurningLeft_shouldFaceEast() {
        Rover rover = aRover(coordinates(1, 2), Direction.SOUTH);
        rover.execute('l');
        assertThat(rover.getDirection()).isEqualTo(Direction.EAST);
    }

    @Test
    void roverFacingWestTurningLeft_shouldFaceSouth() {
        Rover rover = aRover(coordinates(1, 2), Direction.WEST);
        rover.execute('l');
        assertThat(rover.getDirection()).isEqualTo(Direction.SOUTH);
    }

    @Test
    void roversPositionDoNotChangeWhenTurning() {
        Coordinates position = coordinates(1, 2);
        Rover rover = aRover(position, Direction.WEST);
        rover.execute('l');
        assertThat(rover.getPosition()).isEqualTo(position);
    }

    @Test
    void roversTurningMultipleTimes() {
        Coordinates position = coordinates(1, 2);
        Rover rover = aRover(position, Direction.NORTH);
        rover.execute('l', 'l', 'r', 'l');
        assertThat(rover.getDirection()).isEqualTo(Direction.SOUTH);
    }

}

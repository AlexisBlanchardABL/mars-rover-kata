package marsrover;

import org.junit.jupiter.api.Test;

import java.util.List;

import static marsrover.DataSet.*;
import static org.assertj.core.api.Assertions.assertThat;

public class RoverMovesTest {

    @Test
    void roverMovesForwardOnceTowardNorth() {
        Rover rover = aRover(mars(), position(1, 2), Direction.NORTH);
        rover.execute('f');
        assertThat(rover.getPosition()).isEqualTo(position(1, 3));
    }

    @Test
    void roverMovesForwardOnceTowardEast() {
        Rover rover = aRover(mars(), position(1, 2), Direction.EAST);
        rover.execute('f');
        assertThat(rover.getPosition()).isEqualTo(position(2, 2));
    }

    @Test
    void roverMovesForwardTowardSouth() {
        Rover rover = aRover(mars(), position(1, 2), Direction.SOUTH);
        rover.execute('f');
        assertThat(rover.getPosition()).isEqualTo(position(1, 1));
    }

    @Test
    void roverMovesForwardTowardWest() {
        Rover rover = aRover(mars(), position(2, 2), Direction.WEST);
        rover.execute('f');
        assertThat(rover.getPosition()).isEqualTo(position(1, 2));
    }

    @Test
    void roverFacingNorthMovesBackward() {
        Rover rover = aRover(mars(), position(1, 2), Direction.NORTH);
        rover.execute('b');
        assertThat(rover.getPosition()).isEqualTo(position(1, 1));
    }

    @Test
    void roverFacingEastMovesBackward() {
        Rover rover = aRover(mars(), position(2, 2), Direction.EAST);
        rover.execute('b');
        assertThat(rover.getPosition()).isEqualTo(position(1, 2));
    }

    @Test
    void roverFacingSouthMovesBackward() {
        Rover rover = aRover(mars(), position(1, 2), Direction.SOUTH);
        rover.execute('b');
        assertThat(rover.getPosition()).isEqualTo(position(1, 3));
    }

    @Test
    void roverFacingWestMovesBackward() {
        Rover rover = aRover(mars(), position(1, 2), Direction.WEST);
        rover.execute('b');
        assertThat(rover.getPosition()).isEqualTo(position(2, 2));
    }

    @Test
    void roverMovesMultipleTimes() {
        Rover rover = aRover(mars(), position(1, 2), Direction.NORTH);
        rover.execute('f', 'f', 'b', 'f');
        assertThat(rover.getPosition()).isEqualTo(position(1, 4));
    }

    @Test
    void roverMovesOutOfPlanetBoundsGoingToTheLeft() {
        Rover rover = aRover(mars(), position(1, 1), Direction.WEST);
        rover.execute('f');
        assertThat(rover.getPosition()).isEqualTo(position(20, 1));
    }

    @Test
    void roverMovesOutOfPlanetBoundsGoingToTheRight() {
        Rover rover = aRover(mars(), position(20, 1), Direction.EAST);
        rover.execute('f');
        assertThat(rover.getPosition()).isEqualTo(position(1, 1));
    }

    @Test
    void roverMovesOutOfPlanetBoundsGoingUp() {
        Rover rover = aRover(mars(), position(5, 20), Direction.NORTH);
        rover.execute('f');
        assertThat(rover.getPosition()).isEqualTo(position(5, 1));
    }

    @Test
    void roverMovesOutOfPlanetBoundsGoingDown() {
        Rover rover = aRover(mars(), position(5, 1), Direction.SOUTH);
        rover.execute('f');
        assertThat(rover.getPosition()).isEqualTo(position(5, 20));
    }

    @Test
    void roverMovesTowardAnObstacleAndReportObstacle() {
        Position roverPosition = position(5, 7);
        Rover rover = aRover(marsWithObstacles(List.of(new Obstacle(5, 6))), roverPosition, Direction.SOUTH);
        rover.execute('f');
        assertThat(rover.getReport()).isEqualTo("An obstacle was found on Coordinates: 5, 6");
    }

}

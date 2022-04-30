package marsrover;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

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

    @Test
    void roverMovesForwardOnceTowardNorth() {
        Rover rover = aRover(coordinates(1, 2), Direction.N);
        rover.execute(new char[]{'f'});
        assertThat(rover.getPosition()).isEqualTo(coordinates(1, 3));
    }

    @Test
    void roverMovesForwardOnceTowardEast() {
        Rover rover = aRover(coordinates(1, 2), Direction.E);
        rover.execute(new char[]{'f'});
        assertThat(rover.getPosition()).isEqualTo(coordinates(2, 2));
    }

    @Test
    void roverMovesForwardOnceTowardSouth() {
        Rover rover = aRover(coordinates(1, 2), Direction.S);
        rover.execute(new char[]{'f'});
        assertThat(rover.getPosition()).isEqualTo(coordinates(1, 1));
    }

    @Test
    void roverMovesForwardOnceTowardWest() {
        Rover rover = aRover(coordinates(1, 2), Direction.W);
        rover.execute(new char[]{'f'});
        assertThat(rover.getPosition()).isEqualTo(coordinates(0, 2));
    }

    private Coordinates someCoordinates() {
        return coordinates(2, 7);
    }

    private Coordinates coordinates(int x, int y) {
        return new Coordinates(x, y);
    }

    private Rover aRover(Coordinates position, Direction direction) {
        return new Rover(position, direction);
    }

}

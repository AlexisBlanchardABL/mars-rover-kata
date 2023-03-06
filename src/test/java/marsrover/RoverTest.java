package marsrover;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static marsrover.DataSet.*;
import static org.assertj.core.api.Assertions.assertThat;


public class RoverTest {

    @Test
    void shouldInitializeARoverWithItsPosition() {
        Position position = somePosition();
        Rover rover = new Rover(mars(), position, Direction.SOUTH);
        assertThat(rover.getPosition()).isEqualTo(position);
    }

    @Test
    void shouldInitializeARoverOnAPlanet() {
        Planet mars = mars();
        Rover rover = new Rover(mars, somePosition(), Direction.SOUTH);
        assertThat(rover.getPosition()).isEqualTo(somePosition());
    }

    @ParameterizedTest
    @EnumSource(Direction.class)
    void shouldInitializeARoverWithItsDirection(Direction direction) {
        Rover rover = new Rover(mars(), somePosition(), direction);
        assertThat(rover.getDirection()).isEqualTo(direction);
    }

}

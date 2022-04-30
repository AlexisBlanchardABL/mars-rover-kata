package marsrover;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.Assertions.assertThat;


public class RoverTest {

    @ParameterizedTest
    @EnumSource(Direction.class)
    void shouldInitializeARoverWithItsPositionAndDirection(Direction direction) {
        int x = 2;
        int y = 7;
        Coordinates position = new Coordinates(x, y);
        Rover rover = new Rover(position, direction);
        assertThat(rover.getPosition()).isEqualTo(position);
        assertThat(rover.getDirection()).isEqualTo(direction);
    }

}

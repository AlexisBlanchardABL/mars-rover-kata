package marsrover;

import java.util.Collections;
import java.util.List;

public class DataSet {

    static Coordinates someCoordinates() {
        return coordinates(2, 7);
    }

    static Coordinates coordinates(int x, int y) {
        return new Coordinates(x, y);
    }

    static Rover aRover(Planet planet, Coordinates position, Direction direction) {
        return new Rover(planet, position, direction);
    }

    static Planet mars() {
        return new Planet(20, 20, Collections.emptyList());
    }

    static Planet marsWithObstacles(List<Coordinates> obstacles) {
        return new Planet(20, 20, obstacles);
    }

}
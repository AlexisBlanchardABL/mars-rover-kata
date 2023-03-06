package marsrover;

import java.util.Collections;
import java.util.List;

public class DataSet {

    static Position somePosition() {
        return position(2, 7);
    }

    static Position position(int x, int y) {
        return new Position(x, y);
    }

    static Rover aRover(Planet planet, Position position, Direction direction) {
        return new Rover(planet, position, direction);
    }

    static Planet mars() {
        return new Planet(20, 20, Collections.emptyList());
    }

    static Planet marsWithObstacles(List<Obstacle> obstacles) {
        return new Planet(20, 20, obstacles);
    }

}
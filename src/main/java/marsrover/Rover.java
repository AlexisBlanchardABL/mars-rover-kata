package marsrover;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Rover {

    private Direction direction;
    private Coordinates position;

    public Rover(Coordinates position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public Coordinates getPosition() {
        return position;
    }

    public void execute(char... commands) {
        char firstCommand = commands[0];
        if ('r' == firstCommand) {
            direction = Direction.E;
        }
        switch (direction) {
            case N -> position = new Coordinates(this.position.x(), this.position.y() + 1);
            case S -> position = new Coordinates(this.position.x(), this.position.y() - 1);
            case E -> position = new Coordinates(this.position.x() + 1, this.position.y());
            case W -> position = new Coordinates(this.position.x() - 1, this.position.y());
        }
    }

}

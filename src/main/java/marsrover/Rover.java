package marsrover;


import java.util.List;

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
        if (List.of('r', 'l').contains(firstCommand)) {
            turn(firstCommand);
        }
        position = switch (direction) {
            case N -> new Coordinates(this.position.x(), this.position.y() + 1);
            case S -> new Coordinates(this.position.x(), this.position.y() - 1);
            case E -> new Coordinates(this.position.x() + 1, this.position.y());
            case W -> new Coordinates(this.position.x() - 1, this.position.y());
        };
    }

    private void turn(char command) {
        if ('r' == command) {
            direction = switch (direction) {
                case N -> Direction.E;
                case E -> Direction.S;
                case S -> Direction.W;
                case W -> Direction.N;
            };
        }
        if ('l' == command) {
            direction = switch (direction) {
                case N -> Direction.W;
                case E -> Direction.N;
                case S -> Direction.E;
                case W -> Direction.S;
            };
        }
    }

}

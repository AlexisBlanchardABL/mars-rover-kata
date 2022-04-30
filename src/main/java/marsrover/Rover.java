package marsrover;


import java.util.Optional;

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
        Rotate.getValue(firstCommand)
                .ifPresentOrElse((rotation) -> direction = switch (rotation) {
                    case RIGHT -> direction.right();
                    case LEFT -> direction.left();
                }, () -> position = switch (direction) {
                    case N -> new Coordinates(this.position.x(), this.position.y() + 1);
                    case S -> new Coordinates(this.position.x(), this.position.y() - 1);
                    case E -> new Coordinates(this.position.x() + 1, this.position.y());
                    case W -> new Coordinates(this.position.x() - 1, this.position.y());
                });
    }

}

package marsrover;


import java.util.Arrays;
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

    public void execute(Character... commands) {
        Arrays.stream(commands)
                .map(Command::validate)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .forEach(command -> {
                    if (command instanceof Rotate) {
                        rotate((Rotate) command);
                    } else if (command instanceof Move) {
                        move((Move) command);
                    }
                });
    }

    private void move(Move command) {
        position = switch (direction) {
            case NORTH -> position.translate(Move.FORWARD.equals(command) ? Vector.UP : Vector.UP.opposite());
            case SOUTH -> position.translate(Move.FORWARD.equals(command) ? Vector.DOWN : Vector.DOWN.opposite());
            case EAST -> position.translate(Move.FORWARD.equals(command) ? Vector.RIGHT : Vector.RIGHT.opposite());
            case WEST -> position.translate(Move.FORWARD.equals(command) ? Vector.LEFT : Vector.LEFT.opposite());
        };
    }

    private void rotate(Rotate rotation) {
        direction = switch (rotation) {
            case RIGHT -> direction.right();
            case LEFT -> direction.left();
        };
    }

}

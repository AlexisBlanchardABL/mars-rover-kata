package marsrover;


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
                    case NORTH -> position.translate('f' == firstCommand ? Vector.UP : Vector.UP.opposite());
                    case SOUTH -> position.translate('f' == firstCommand ? Vector.DOWN : Vector.DOWN.opposite());
                    case EAST -> position.translate('f' == firstCommand ? Vector.RIGHT : Vector.RIGHT.opposite());
                    case WEST -> position.translate('f' == firstCommand ? Vector.LEFT : Vector.LEFT.opposite());
                });
    }

}

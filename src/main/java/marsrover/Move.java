package marsrover;

public enum Move implements Command {

    FORWARD('f'),
    BACKWARD('b');

    private final char command;
    private boolean executedWithSuccess;

    Move(char command) {
        this.command = command;
    }

    private Vector vectorFrom(Direction currentDirection) {
        return switch (currentDirection) {
            case NORTH -> FORWARD.equals(this) ? Vector.UP : Vector.UP.opposite();
            case SOUTH -> FORWARD.equals(this) ? Vector.DOWN : Vector.DOWN.opposite();
            case EAST -> FORWARD.equals(this) ? Vector.RIGHT : Vector.RIGHT.opposite();
            case WEST -> FORWARD.equals(this) ? Vector.LEFT : Vector.LEFT.opposite();
        };
    }

    @Override
    public Character value() {
        return command;
    }

    @Override
    public Move executeOn(Rover rover) {
        Vector vector = vectorFrom(rover.getDirection());
        moveRover(rover, vector);
        return this;
    }

    private void moveRover(Rover rover, Vector vector) {
        rover.computeNextPosition(vector)
                .ifPresent(newPosition -> {
                    this.executedWithSuccess = true;
                    rover.updatePosition(newPosition);
                });
    }

    public boolean isSuccess() {
        return executedWithSuccess;
    }

}

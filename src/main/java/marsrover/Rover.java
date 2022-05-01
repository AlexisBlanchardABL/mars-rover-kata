package marsrover;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Rover {

    private final Planet planet;
    private Direction direction;
    private Coordinates position;
    private String report;

    public Rover(Planet planet, Coordinates position, Direction direction) {
        this.planet = planet;
        this.position = position;
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public Coordinates getPosition() {
        return position;
    }

    public void execute(Character... inputCommands) {
        for (Command command : validCommands(inputCommands)) {
            if (command instanceof Rotation) {
                rotate((Rotation) command);
            } else if (command instanceof Move) {
                Move move = move((Move) command);
                if (!move.isSuccess()) {
                    break;
                }
            }
        }
    }

    private List<Command> validCommands(Character[] commands) {
        return Arrays.stream(commands)
                .map(Command::validate)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
    }

    private Move move(Move command) {
        Vector vector = vectorFrom(direction, command);
        computeNextPosition(vector)
                .ifPresent(newPosition -> {
                    command.success(true);
                    this.position = newPosition;
                });
        return command;
    }

    private Optional<Coordinates> computeNextPosition(Vector vector) {
        Coordinates nextPosition = getPlanetWrappedPosition(vector, this.position.translate(vector));
        if (this.planet.obstacles().contains(nextPosition)) {
            reportObstacle(nextPosition);
            return Optional.empty();
        }
        return Optional.of(nextPosition);
    }

    private Coordinates getPlanetWrappedPosition(Vector vector, Coordinates position) {
        return this.planet.contains(position) ? position : this.planet.wrapPositionAroundPlanet(this.position, vector);
    }

    private void reportObstacle(Coordinates obstacleCoordinate) {
        this.report = String.format("An obstacle was found on Coordinates: %s, %s", obstacleCoordinate.x(), obstacleCoordinate.y());
    }

    private static Vector vectorFrom(Direction currentDirection, Move move) {
        return switch (currentDirection) {
            case NORTH -> Move.FORWARD.equals(move) ? Vector.UP : Vector.UP.opposite();
            case SOUTH -> Move.FORWARD.equals(move) ? Vector.DOWN : Vector.DOWN.opposite();
            case EAST -> Move.FORWARD.equals(move) ? Vector.RIGHT : Vector.RIGHT.opposite();
            case WEST -> Move.FORWARD.equals(move) ? Vector.LEFT : Vector.LEFT.opposite();
        };
    }

    private void rotate(Rotation rotation) {
        direction = direction.rotate(rotation);
    }

    public String getReport() {
        return report;
    }

}

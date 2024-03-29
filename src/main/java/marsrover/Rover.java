package marsrover;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Rover {

    private final Planet planet;
    private Direction direction;
    private Position position;
    private String report;

    public Rover(Planet planet, Position position, Direction direction) {
        this.planet = planet;
        this.position = position;
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public Position getPosition() {
        return position;
    }

    public void execute(Character... inputCommands) {
        for (Command command : validCommands(inputCommands)) {
            if (Boolean.FALSE.equals(command.executeOn(this).isSuccess())) {
                break;
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

    Optional<Position> computeNextPosition(Vector vector) {
        Position nextPosition = getPlanetWrappedPosition(vector, this.position.translate(vector));
        if (this.planet.isObstacleOn(nextPosition)) {
            reportObstacle(nextPosition);
            return Optional.empty();
        }
        return Optional.of(nextPosition);
    }

    private Position getPlanetWrappedPosition(Vector vector, Position position) {
        return this.planet.contains(position) ? position : this.planet.wrapPositionAroundPlanet(this.position, vector);
    }

    private void reportObstacle(Coordinates obstacleCoordinate) {
        this.report = String.format("An obstacle was found on Coordinates: %s, %s", obstacleCoordinate.x(), obstacleCoordinate.y());
    }

    public void rotate(Rotation rotation) {
        direction = direction.rotate(rotation);
    }

    public String getReport() {
        return report;
    }

    public void updatePosition(Position newPosition) {
        position = newPosition;
    }

}

package marsrover;

import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public record Planet(int xLimit, int yLimit, List<Obstacle> obstacles) {

    public boolean contains(Coordinates coordinates) {
        return !(
                coordinates.x() <= 0 ||
                        coordinates.x() > xLimit ||
                        coordinates.y() <= 0 ||
                        coordinates.y() > yLimit
        );
    }

    public Position wrapPositionAroundPlanet(Position currentRoverPosition, Vector vector) {
        return switch (vector) {
            case UP -> new Position(currentRoverPosition.x(), 1);
            case DOWN -> new Position(currentRoverPosition.x(), this.yLimit);
            case LEFT -> new Position(this.xLimit, currentRoverPosition.y());
            case RIGHT -> new Position(1, currentRoverPosition.y());
        };
    }

    public boolean isObstacleOn(Coordinates coordinate) {
        return this.obstacles.stream().anyMatch(matchesObstacle(coordinate));
    }

    private Predicate<Coordinates> matchesObstacle(Coordinates coordinate) {
        return obstacle -> Objects.equals(obstacle.x, coordinate.x) && Objects.equals(obstacle.y, coordinate.y);
    }

}

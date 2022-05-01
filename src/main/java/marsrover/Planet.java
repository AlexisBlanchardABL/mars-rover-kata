package marsrover;

public class Planet {
    private final int xLimit;
    private final int yLimit;

    public Planet(int xLimit, int yLimit) {
        this.xLimit = xLimit;
        this.yLimit = yLimit;
    }

    public boolean contains(Coordinates coordinates) {
        return !(
                coordinates.x() <= 0 ||
                        coordinates.x() > xLimit ||
                        coordinates.y() <= 0 ||
                        coordinates.y() > yLimit
        );
    }

    public Coordinates wrapPositionAroundPlanet(Coordinates currentRoverPosition, Vector vector) {
        return switch (vector) {
            case UP -> new Coordinates(currentRoverPosition.x(), 1);
            case DOWN -> new Coordinates(currentRoverPosition.x(), this.yLimit);
            case LEFT -> new Coordinates(this.xLimit, currentRoverPosition.y());
            case RIGHT -> new Coordinates(1, currentRoverPosition.y());
        };
    }
}

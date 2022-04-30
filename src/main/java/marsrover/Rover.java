package marsrover;

public record Rover(Coordinates position, Direction direction) {

    public Direction getDirection() {
        return direction;
    }

    public Coordinates getPosition() {
        return position;
    }

}

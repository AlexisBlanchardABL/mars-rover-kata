package marsrover;

public class Rover {

    private final Direction direction;
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

    public void execute(char[] commands) {
        position = new Coordinates(this.position.x(), this.position.y()+1);
    }

}

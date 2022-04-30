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
        if ('r' == firstCommand) {
            switch (direction) {
                case N -> direction = Direction.E;
                case E -> direction = Direction.S;
                case S -> direction = Direction.W;
                case W -> direction = Direction.N;
            }
        }
        if ('l' == firstCommand) {
            switch (direction) {
                case N -> direction = Direction.W;
                case E -> direction = Direction.N;
                case S -> direction = Direction.E;
                case W -> direction = Direction.S;
            }
        }
        switch (direction) {
            case N -> position = new Coordinates(this.position.x(), this.position.y() + 1);
            case S -> position = new Coordinates(this.position.x(), this.position.y() - 1);
            case E -> position = new Coordinates(this.position.x() + 1, this.position.y());
            case W -> position = new Coordinates(this.position.x() - 1, this.position.y());
        }
    }

}

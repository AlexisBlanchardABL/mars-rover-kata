package marsrover;

public enum Move implements Command {

    FORWARD('f'),
    BACKWARD('b');

    private final char command;

    Move(char command) {
        this.command = command;
    }

    @Override
    public Character value() {
        return command;
    }

}

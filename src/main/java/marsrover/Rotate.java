package marsrover;


public enum Rotate implements Command {
    LEFT('l'),
    RIGHT('r');

    private final char command;

    Rotate(char command) {
        this.command = command;
    }

    @Override
    public Character value() {
        return command;
    }

}

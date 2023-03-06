package marsrover;


public enum Rotation implements Command {
    LEFT('l'),
    RIGHT('r');

    private final char command;

    Rotation(char command) {
        this.command = command;
    }

    @Override
    public Character value() {
        return command;
    }

    @Override
    public Command executeOn(Rover rover) {
        rover.rotate(this);
        return this;
    }

    @Override
    public boolean isSuccess() {
        return true;
    }

}

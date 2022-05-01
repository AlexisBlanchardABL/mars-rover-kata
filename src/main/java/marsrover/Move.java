package marsrover;

public enum Move implements Command {

    FORWARD('f'),
    BACKWARD('b');

    private final char command;
    private boolean executedWithSuccess;

    Move(char command) {
        this.command = command;
    }

    @Override
    public Character value() {
        return command;
    }

    public void success(boolean success) {
        this.executedWithSuccess = success;
    }

    public boolean isSuccess() {
        return executedWithSuccess;
    }

}

package marsrover;

import java.util.Arrays;
import java.util.Optional;

public enum Rotate {
    LEFT('l'), RIGHT('r');

    private final char command;

    Rotate(char command) {
        this.command = command;
    }

    public static Optional<Rotate> getValue(char cmd) {
        return Arrays.stream(values()).filter(value -> value.command == cmd).findAny();
    }

}

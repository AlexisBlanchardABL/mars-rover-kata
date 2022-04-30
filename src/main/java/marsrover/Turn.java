package marsrover;

import java.util.Arrays;
import java.util.Optional;

public enum Turn {
    RIGHT('r'), LEFT('l');

    private final char command;

    Turn(char command) {
        this.command = command;
    }

    public static Optional<Turn> getValue(char cmd) {
        return Arrays.stream(values()).filter(value -> value.command == cmd).findAny();
    }

}

package marsrover;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

public interface Command {

    private static List<Command> values() {
        return Stream.of(
                        List.<Command>of(Rotation.values()),
                        List.<Command>of(Move.values())
                )
                .flatMap(Collection::stream)
                .toList();
    }

    static Optional<Command> validate(Character command) {
        return values()
                .stream()
                .filter(validCommands -> Objects.equals(validCommands.value(), command))
                .findAny();
    }

    Character value();

    Command executeOn(Rover rover);

    boolean isSuccess();

}

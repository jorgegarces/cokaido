import navCommands.Command;
import position.Position;

import java.util.Objects;

public class MarsRover {

    private final Position position;

    public MarsRover() {
        position = new Position(0, 0, 'N');
    }

    public MarsRover(int latitude, int longitude, char orientation) {
        position = new Position(latitude, longitude, orientation);
    }

    public void navigate(String movement) {
        for (int i = 0; i < movement.length(); i++) {
            run(Command.create(movement.charAt(i), position));
        }
    }

    private void run(Command command) {
        command.execute();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MarsRover marsRover = (MarsRover) o;
        return Objects.equals(position, marsRover.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}

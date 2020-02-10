import java.util.Objects;

public class MarsRover {

    private final Position position;

    public MarsRover() {
        position = new Position(0,0,'N');
    }

    public MarsRover(int positionX, int positionY, char orientation) {
        position = new Position(positionX, positionY, orientation);
    }

    public void navigate(String movement) {
        for (int i = 0; i < movement.length(); i++) {
            run(new Command(movement.charAt(i)));
        }
    }

    private void run(Command command) {
        command.execute(position);
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

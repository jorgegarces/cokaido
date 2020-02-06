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
            run(movement.charAt(i));
        }
    }

    private void run(char command) {
        if (command == 'F') position.moveForward();
        if (command == 'R') position.rotateRight();
        if (command == 'L') position.rotateLeft();
        if (command == 'B') position.moveBackwards();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MarsRover marsRover = (MarsRover) o;
        return position.positionX == marsRover.position.positionX &&
                position.positionY == marsRover.position.positionY &&
                position.orientation == marsRover.position.orientation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position.positionX, position.positionY, position.orientation);
    }

    @Override
    public String toString() {
        return "MarsRover{" +
                "positionX=" + position.positionX +
                ", positionY=" + position.positionY +
                ", orientation=" + position.orientation +
                '}';
    }
}

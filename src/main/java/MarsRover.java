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
        if (command == 'F') moveForward();
        if (command == 'R') rotateRight();
        if (command == 'L') rotateLeft();
        if (command == 'B') moveBackwards();
    }

    private void rotateLeft() {
        if (this.position.orientation == 'N') this.position.orientation = 'W';
        else if (this.position.orientation == 'E') this.position.orientation = 'N';
        else if (this.position.orientation == 'S') this.position.orientation = 'E';
        else if (this.position.orientation == 'W') this.position.orientation = 'S';
    }

    private void rotateRight() {
        if (this.position.orientation == 'N') this.position.orientation = 'E';
        else if (this.position.orientation == 'E') this.position.orientation = 'S';
        else if (this.position.orientation == 'S') this.position.orientation = 'W';
        else if (this.position.orientation == 'W') this.position.orientation = 'N';
    }

    private void moveForward() {
        if (this.position.orientation == 'N') this.position.positionY = this.position.positionY + 1;
        if (this.position.orientation == 'E') this.position.positionX = this.position.positionX + 1;
        if (this.position.orientation == 'S') this.position.positionY = this.position.positionY - 1;
        if (this.position.orientation == 'W') this.position.positionX = this.position.positionX - 1;
    }

    private void moveBackwards() {
        if (this.position.orientation == 'N') this.position.positionY = this.position.positionY - 1;
        if (this.position.orientation == 'E') this.position.positionX = this.position.positionX - 1;
        if (this.position.orientation == 'S') this.position.positionY = this.position.positionY + 1;
        if (this.position.orientation == 'W') this.position.positionX = this.position.positionX + 1;
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

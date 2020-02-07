import java.util.Objects;

public class Position {

    private Orientation orientation;
    private int positionX;
    private int positionY;

    public Position(int positionX, int positionY, char orientation) {

        this.positionX = positionX;
        this.positionY = positionY;
        this.orientation = Orientation.create(orientation);
    }

    void rotateLeft() {
        this.orientation = orientation.rotateLeft();
    }

    void rotateRight() {
        this.orientation = orientation.rotateRight();
    }

    void moveForward() {
        if (orientation instanceof North) positionY = positionY + 1;
        if (orientation instanceof East) positionX = positionX + 1;
        if (orientation instanceof South) positionY = positionY - 1;
        if (orientation instanceof West) positionX = positionX - 1;
    }

    void moveBackwards() {
        if (orientation instanceof North) positionY = positionY - 1;
        if (orientation instanceof East) positionX = positionX - 1;
        if (orientation instanceof South) positionY = positionY + 1;
        if (orientation instanceof West) positionX = positionX + 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return positionX == position.positionX &&
                positionY == position.positionY &&
                position.orientation.getClass() == this.orientation.getClass();
    }

    @Override
    public int hashCode() {
        return Objects.hash(orientation, positionX, positionY);
    }
}
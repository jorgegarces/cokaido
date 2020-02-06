import java.util.Objects;

public class MarsRover {

    private final int positionX;
    private final int positionY;
    private final char orientation;

    public MarsRover() {
        this.positionX = 0;
        this.positionY = 0;
        this.orientation = 'N';
    }

    public MarsRover(int positionX, int positionY, char orientation) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.orientation = orientation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MarsRover marsRover = (MarsRover) o;
        return positionX == marsRover.positionX &&
                positionY == marsRover.positionY &&
                orientation == marsRover.orientation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(positionX, positionY, orientation);
    }
}

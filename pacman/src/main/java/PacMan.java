import java.util.Objects;

public class PacMan {

    private int x;
    private int y;
    private Direction direction;

    public PacMan(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void moveRight() {
        this.x++;
        this.direction = Direction.RIGHT;
    }

    public void moveLeft() {
        this.x--;
        this.direction = Direction.LEFT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PacMan pacMan = (PacMan) o;
        return x == pacMan.x &&
                y == pacMan.y &&
                Objects.equals(direction, pacMan.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, direction);
    }

    @Override
    public String toString() {
        return "PacMan{" +
                "x=" + x +
                ", y=" + y +
                ", direction='" + direction + '\'' +
                '}';
    }
}

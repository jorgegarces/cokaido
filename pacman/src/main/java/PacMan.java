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

    public Cell move(Cell destination, Move move) {
        if (destination == Cell.WALL) return Cell.PACMAN;
        if (move == Move.RIGHT) moveRight();
        if (move == Move.LEFT) moveLeft();
        if (move == Move.UP) moveUp();
        if (move == Move.DOWN) moveDown();
        return Cell.EMPTY;
    }

    private void moveRight() {
        this.x++;
        this.direction = Direction.RIGHT;

    }

    private void moveLeft() {
        this.x--;
        this.direction = Direction.LEFT;
    }

    private void moveUp() {
        this.y++;
        this.direction = Direction.UP;
    }

    private void moveDown() {
        this.y--;
        this.direction = Direction.DOWN;
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

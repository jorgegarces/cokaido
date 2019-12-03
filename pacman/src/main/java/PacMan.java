import java.util.Objects;

public class PacMan {

    private int x;
    private int y;

    public PacMan(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public PacMan() {
        this.x = 0;
        this.y = 0;
    }


    public void moveRight() {
        this.y++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PacMan pacMan = (PacMan) o;
        return x == pacMan.x &&
                y == pacMan.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

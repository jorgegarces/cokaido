import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Position {

    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public List<Position> neighbors(){
        List<Position> neighbors = new ArrayList<>();

        neighbors.add(new Position(x + 1, y));
        neighbors.add(new Position(x + 1, y + 1));
        neighbors.add(new Position(x - 1, y));
        neighbors.add(new Position(x - 1, y - 1));
        neighbors.add(new Position(x, y + 1));
        neighbors.add(new Position(x, y - 1));
        neighbors.add(new Position(x + 1, y - 1));
        neighbors.add(new Position(x - 1, y + 1));

        return neighbors;
    }



    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x &&
                y == position.y;
    }
}
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Board {
    public Map<Integer, Integer> grid = new HashMap<>();

    public void addCell(int x, int y){
        this.grid.put(x,y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board = (Board) o;
        return Objects.equals(grid, board.grid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(grid);
    }
}
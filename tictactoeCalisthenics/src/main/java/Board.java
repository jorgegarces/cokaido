import java.util.HashMap;
import java.util.Map;

public class Board {
    private Map<Cell,Movement> grid = new HashMap<>();

    public void addPosition(Cell position, Movement movement) {
        if(this.grid.containsKey(position)) throw new RuntimeException();
        this.grid.put(position, movement);
    }

    public Response checkWinner() {
        if(grid.get(Cell.ZERO) == grid.get(Cell.ONE) && grid.get(Cell.ONE) == grid.get(Cell.TWO)) return Response.YOUWIN;
        return Response.TURNO;
    }
}
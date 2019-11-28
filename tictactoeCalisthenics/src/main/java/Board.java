import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Cell> board = new ArrayList<>();

    public void addPosition(Cell position) {
        if(this.board.contains(position)) throw new RuntimeException();
        this.board.add(position);
    }
}
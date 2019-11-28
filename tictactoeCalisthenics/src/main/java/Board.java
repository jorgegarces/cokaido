import org.graalvm.compiler.lir.sparc.SPARCMove;

import java.util.HashMap;
import java.util.Map;

public class Board {
    private Map<Cell,Movement> board = new HashMap<>();

    public void addPosition(Cell position, Movement movement) {
        if(this.board.containsKey(position)) throw new RuntimeException();
        this.board.put(position, movement);
    }
    public Movement getMovementFromGivenPosition (Cell position){
       if(this.board.containsKey(position)) return this.board.get(position);
       return Movement.NONE;
    }
}
import java.util.Objects;

public class GameOfLife {

public Board board = new Board();

 public void addLivingCell(int x, int y){
     board.addCell(x,y);
 }

 public void runGame() {
     board.grid.remove(0);
 }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameOfLife that = (GameOfLife) o;
        return Objects.equals(board, that.board);
    }

    @Override
    public int hashCode() {
        return Objects.hash(board);
    }
}
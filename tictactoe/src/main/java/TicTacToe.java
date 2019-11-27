public class TicTacToe {
    String lastMove = "O";
    public boolean move(String move) {
        if (move != lastMove) {
            lastMove = move;
            return true;
        }
        return false;
    }
}
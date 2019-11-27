import java.util.List;

public class TicTacToe {
    String lastMove = "O";
    String[] board = {"", "", "", "", "", "", "", "", ""};
    public boolean move(String move, Integer position) {

        if (move != lastMove && board[position] == "") {
            lastMove = move;
            board[position] = move;
            return true;
        }
        return false;

    }
}
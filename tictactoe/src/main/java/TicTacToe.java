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

    public boolean checkWinner() {
        if(board[0] == board[1] && board[1] == board[2]) return true;
        return false;
    }
}
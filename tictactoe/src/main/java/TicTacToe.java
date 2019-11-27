import java.util.Arrays;
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
        if(board[3] == board[4] && board[4] == board[5]) return true;
        if(board[6] == board[7] && board[7] == board[8]) return true;
        return false;
    }

    public boolean checkDraw() {
        if(!checkWinner() && !Arrays.asList(board).contains("")) return true;
        return false;
    }
}
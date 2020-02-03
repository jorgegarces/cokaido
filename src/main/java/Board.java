import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Tile> _plays = new ArrayList<>();

    public Board() {
        generateBoard();
    }

    private void generateBoard() {
        for (int i = 0; i < 3; i++) {
            createVerticalPositions(i);
        }
    }

    private void createVerticalPositions(int i) {
        for (int j = 0; j < 3; j++) {
            Tile tile = new Tile(i, j, ' ');
            _plays.add(tile);
        }
    }

    public Tile tileAt(int x, int y) {
        for (Tile tile : _plays) {
            if (tile.hasSamePosition(x, y)) {
                return tile;
            }
        }
        return null;
    }

    public void AddTileAt(char symbol, int x, int y) {
        tileAt(x, y).Symbol = symbol;
    }

    public char winner() {  // long method
        for (int i = 0; i < 3; i++) {
            if (rowIsNotEmpty(i)) {
                if (isWinningRow(i)) {
                    return tileAt(i, 0).Symbol;
                }
            }

        }

        return ' ';
    }

    private boolean isWinningRow(int i) {
        return tileAt(i, 0).Symbol ==
                tileAt(i, 1).Symbol &&
                tileAt(i, 2).Symbol == tileAt(i, 1).Symbol;
    }

    private boolean rowIsNotEmpty(int i) {
        return tileAt(i, 0).Symbol != ' ' &&
                tileAt(i, 1).Symbol != ' ' &&
                tileAt(i, 2).Symbol != ' ';
    }
}
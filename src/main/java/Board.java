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
        tileAt(x, y).setSymbol(symbol);
    }

    public char winner() {
        for (int x = 0; x < 3; x++) {
            if (rowIsNotEmpty(x)) {
                if (isWinningRow(x)) {
                    return tileAt(x, 0).getSymbol();
                }
            }
        }
        return ' ';
    }

    private boolean isWinningRow(int x) {
        return tileAt(x, 0).getSymbol() ==
                tileAt(x, 1).getSymbol() &&
                tileAt(x, 2).getSymbol() == tileAt(x, 1).getSymbol();
    }

    private boolean rowIsNotEmpty(int x) {
        return tileAt(x, 0).getSymbol() != ' ' &&
                tileAt(x, 1).getSymbol() != ' ' &&
                tileAt(x, 2).getSymbol() != ' ';
    }
}
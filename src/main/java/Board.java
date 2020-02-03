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
            if (tile.hasSamePosition(new Tile(x, y, ' '))) {
                return tile;
            }
        }
        return null;
    }

    public void replaceTileAt(Tile newTile) {
        for (Tile tile : _plays) {
            if (tile.hasSamePosition(newTile)) {
                tile.update(newTile);
            }
        }
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
        return getSymbol(x, 0) ==
                getSymbol(x, 1) &&
                getSymbol(x, 2) == getSymbol(x, 1);
    }

    private boolean rowIsNotEmpty(int x) {
        for (int y = 0; y < 3; y++) {
            if (getSymbol(x, y) == ' ') return false;
        }
        return true;
    }

    char getSymbol(int x, int y) {
        return tileAt(x, y).getSymbol();
    }
}
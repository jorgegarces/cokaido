import java.util.ArrayList;
import java.util.List;

public class Board
{
    private List<Tile> _plays = new ArrayList<>();

    public Board()
    {
        for (int i = 0; i < 3; i++) // One level of indentation
        {
            createVerticalPositions(i);
        }
    }

    private void createVerticalPositions(int i) {
        for (int j = 0; j < 3; j++)
        {
            Tile tile = new Tile(i, j,  ' ');
            _plays.add(tile);
        }
    }

    public Tile tileAt(int x, int y)
    {
        for (Tile tile : _plays) {
            if (tile.hasSamePosition(x, y)){
                return tile;
            }
        }
        return null;
    }

    public void AddTileAt(char symbol, int x, int y)
    {
        tileAt(x,y).Symbol = symbol;
    }

    public char winner() {  // long method // duplication
        //if the positions in first row are taken  // no coments
        if (tileAt(0, 0).Symbol != ' ' &&
                tileAt(0, 1).Symbol != ' ' &&
                tileAt(0, 2).Symbol != ' ') {
            //if first row is full with same symbol
            if (tileAt(0, 0).Symbol ==
                    tileAt(0, 1).Symbol &&
                    tileAt(0, 2).Symbol == tileAt(0, 1).Symbol) {
                return tileAt(0, 0).Symbol;
            }
        }

        //if the positions in first row are taken
        if (tileAt(1, 0).Symbol != ' ' &&
                tileAt(1, 1).Symbol != ' ' &&
                tileAt(1, 2).Symbol != ' ') {
            //if middle row is full with same symbol
            if (tileAt(1, 0).Symbol ==
                    tileAt(1, 1).Symbol &&
                    tileAt(1, 2).Symbol ==
                            tileAt(1, 1).Symbol) {
                return tileAt(1, 0).Symbol;
            }
        }

        //if the positions in first row are taken
        if (tileAt(2, 0).Symbol != ' ' &&
                tileAt(2, 1).Symbol != ' ' &&
                tileAt(2, 2).Symbol != ' ') {
            //if middle row is full with same symbol
            if (tileAt(2, 0).Symbol ==
                    tileAt(2, 1).Symbol &&
                    tileAt(2, 2).Symbol ==
                            tileAt(2, 1).Symbol) {
                return tileAt(2, 0).Symbol;
            }
        }

        return ' ';
    }
}
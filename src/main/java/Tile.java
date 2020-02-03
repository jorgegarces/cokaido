
public class Tile
{
    private int X;
    private int Y;
    private char Symbol;

    public Tile(int x, int y, char symbol) {
        X = x;
        Y = y;
        Symbol = symbol;
    }

    boolean hasSamePosition(Tile tile) {
        return X == tile.X && Y == tile.Y;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public char getSymbol() {
        return Symbol;
    }

    public void update(Tile tile){
        this.Symbol = tile.Symbol;
    }
}

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

    boolean hasSamePosition(int x, int y) {
        return X == x && Y == y;
    }

    public char getSymbol() {
        return Symbol;
    }

    public void setSymbol(char symbol) {
        Symbol = symbol;
    }
}
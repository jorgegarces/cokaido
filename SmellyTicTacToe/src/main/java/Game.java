public class Game {
    private char _lastSymbol = ' ';
    Board _board = new Board();

    public void Play(char symbol, int x, int y) throws Exception { //primitive obsession
        if (isFirstMove() && isPlayerO(symbol)) throw new Exception("Invalid first player");
        if (isSamePlayer(symbol)) throw new Exception("Invalid next player");
        if (isTileAlreadyTaken(x, y)) throw new Exception("Invalid position");
        updateGameState(symbol, x, y);
    }

    private void updateGameState(char symbol, int x, int y) {
        _lastSymbol = symbol;
        _board.replaceTileAt(new Tile(x, y, symbol));
    }

    private boolean isTileAlreadyTaken(int x, int y) {
        return _board.getSymbol(x, y) != ' ';
    }

    private boolean isSamePlayer(char symbol) {
        return symbol == _lastSymbol;
    }

    private boolean isPlayerO(char symbol) {
        return symbol == 'O';
    }

    private boolean isFirstMove() {
        return _lastSymbol == ' ';
    }

}


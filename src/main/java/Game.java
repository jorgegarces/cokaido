public class Game {
    private char _lastSymbol = ' ';
    Board _board = new Board();

    public void Play(char symbol, int x, int y) throws Exception { //primitive obsesion
        //if first move
        if (_lastSymbol == ' ') {
            //if player is X
            if (symbol == 'O') {
                throw new Exception("Invalid first player");
            }
        }
        //if not first move but player repeated
        else if (symbol == _lastSymbol) {
            throw new Exception("Invalid next player");
        }
        //if not first move but play on an already played tile
        else if (_board.getSymbol(x, y) != ' ') { // mesage chain
            throw new Exception("Invalid position");
        }

        // update game state
        _lastSymbol = symbol;
        _board.replaceTileAt(new Tile(x, y, symbol));
    }

}


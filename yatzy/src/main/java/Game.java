import java.util.Arrays;

public class Game {

    private final Roll _currentRoll;
    private final String _category;

    public Game(Roll currentRoll, String category) {
        _currentRoll = currentRoll;
        _category = category;
    }

    public Score calculateScore() {
        if(_category == "yatzy") return _currentRoll.calculateYatzy();
        /*if (_category == "chance") return new Score(Arrays.stream(_currentRoll).sum());
        if (_category == "ones") return new Score(Arrays.stream(_currentRoll).filter((item)-> item == 1).sum());
        if (_category == "pair of ones") return new Score((int) Arrays.stream(_currentRoll).filter((item)-> item ==1).count());*/


        return new Score(0);
    }
}
import java.util.Arrays;

public class Game {

    private final Roll _currentRoll;

    public Game(Roll currentRoll) {
        _currentRoll = currentRoll;

    }

    public Score calculateScore() {
        return _currentRoll.calculate();
       // if (_category == "pair of ones") return new Score((int) Arrays.stream(_currentRoll).filter((item)-> item ==1).count());
    }
}
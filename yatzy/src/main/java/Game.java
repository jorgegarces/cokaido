import java.util.Arrays;
import java.util.HashSet;

public class Game {

    private final int[] _diceRoll;
    private final String _category;

    public Game(int[] diceRoll, String category) {
        _diceRoll = diceRoll;
        _category = category;
    }

    public Score calculateScore() {

        if (_category == "yatzy" && Arrays.stream(_diceRoll).allMatch((item)-> item == _diceRoll[0]))
            return new Score(50);
        if (_category == "chance") return new Score(Arrays.stream(_diceRoll).sum());
        if (_category == "ones") return new Score(Arrays.stream(_diceRoll).filter((item)-> item == 1).sum());

        return new Score(0);
    }
}

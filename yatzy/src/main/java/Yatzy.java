public class Yatzy {

    private final int[] _diceRoll;
    private final String _category;

    public Yatzy(int[] diceRoll, String category) {
        _diceRoll = diceRoll;
        _category = category;
    }

    public Score calculateScore() {
        if (_category == "yatzy") return new Score(50);

        return new Score(0);
    }
}

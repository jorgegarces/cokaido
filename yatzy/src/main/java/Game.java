public class Game {

    private final RollStats _rollStats;
    private Roll _currentRoll;

    public Game(Roll currentRoll) {
        _rollStats = new RollStats();
        _currentRoll = currentRoll;
        _rollStats.addRoll(currentRoll);
    }

    public Score calculateScore() {
        return _rollStats.calculateTotalScore();
    }

    public void addRoll(Roll currentRoll) {
        _currentRoll = currentRoll;
        _rollStats.addRoll(currentRoll);
    }

    @Override
    public String toString() {
        return "Game{" +
                "_rollStats=" + _rollStats +
                ", _currentRoll=" + _currentRoll +
                '}';
    }
}
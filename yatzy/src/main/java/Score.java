public class Score {

    private int _value;

    public Score(int value) {
        _value = value;
    }

    @Override
    public boolean equals(Object obj) {
        return equals((Score) obj);
    }

    private boolean equals(Score otherScore) {
        return otherScore._value == _value;
    }

    @Override
    public String toString() {
        return "Score{" +
                "_value=" + _value +
                '}';
    }

    public Score sum(Score otherScore) {
        return new Score(this._value + otherScore._value);
    }
}

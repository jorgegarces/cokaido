public enum DiceValue {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6);

    private final int valueCode;

    DiceValue(int valueCode) {this.valueCode = valueCode;}
}
public abstract class Roll {

    public int[] rollArray;

    public Roll(DiceValue diceValue1, DiceValue diceValue2, DiceValue diceValue3, DiceValue diceValue4, DiceValue diceValue5) {
        rollArray = new int[]{diceValue1.toInt(), diceValue2.toInt(), diceValue3.toInt(), diceValue4.toInt(), diceValue5.toInt()};
    }

    public abstract Score calculate();
}
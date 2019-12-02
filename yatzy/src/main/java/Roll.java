import java.util.Arrays;

public class Roll {

    public int[] rollArray;

    public Roll(DiceValue diceValue1, DiceValue diceValue2, DiceValue diceValue3, DiceValue diceValue4, DiceValue diceValue5) {
        rollArray = new int[]{diceValue1.ordinal(), diceValue2.ordinal(), diceValue3.ordinal(), diceValue4.ordinal(), diceValue5.ordinal()};
    }

    public Score calculateYatzy() {
       if (Arrays.stream(this.rollArray).allMatch((item)-> item == this.rollArray[0])) return new Score(50);
       return new Score(0);
    }
}
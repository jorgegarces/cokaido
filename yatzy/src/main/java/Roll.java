import java.util.Arrays;

public class Roll {

    public int[] rollArray;

    public Roll(DiceValue diceValue1, DiceValue diceValue2, DiceValue diceValue3, DiceValue diceValue4, DiceValue diceValue5) {
        rollArray = new int[]{diceValue1.toInt(), diceValue2.toInt(), diceValue3.toInt(), diceValue4.toInt(), diceValue5.toInt()};
    }

    public Score calculateYatzy() {
       if (Arrays.stream(this.rollArray).allMatch((item)-> item == this.rollArray[0])) return new Score(50);
       return new Score(0);
    }

    public Score calculateChance(){
        return new Score(Arrays.stream(this.rollArray).sum());
    }
}
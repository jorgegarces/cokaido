import java.util.Arrays;

public class Yatzy extends Roll {

    public Yatzy(DiceValue diceValue1, DiceValue diceValue2, DiceValue diceValue3, DiceValue diceValue4, DiceValue diceValue5){
        super(diceValue1, diceValue2, diceValue3, diceValue4, diceValue5);
    }

    public Score calculate(){
       if (Arrays.stream(this.rollArray).allMatch((item)-> item == this.rollArray[0])) return new Score(50);
       return new Score(0);
    }
}
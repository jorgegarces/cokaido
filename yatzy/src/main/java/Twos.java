import java.util.Arrays;

public class Twos extends Roll {
    public Twos(DiceValue diceValue1, DiceValue diceValue2, DiceValue diceValue3, DiceValue diceValue4, DiceValue diceValue5){
        super(diceValue1, diceValue2, diceValue3, diceValue4, diceValue5);
    }
    @Override
    public Score calculate() {
        return new Score(Arrays.stream(this.rollArray).filter((item)-> item == 2).sum());
    }
}

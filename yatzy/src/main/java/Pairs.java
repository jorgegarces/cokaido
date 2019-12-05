import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Pairs extends Roll {
    public Pairs(DiceValue diceValue1, DiceValue diceValue2, DiceValue diceValue3, DiceValue diceValue4, DiceValue diceValue5) {
        super(diceValue1, diceValue2, diceValue3, diceValue4, diceValue5);
    }

    @Override
    public Score calculate() {
        Arrays.sort(this.rollArray);
        int value = 0;
        for(int i = this.rollArray.length -1 ; i >= 0 ; i--){
            if(this.rollArray[i] == value) return new Score(value + value);
            value = this.rollArray[i];
        }

      return new Score(0);
    }

}

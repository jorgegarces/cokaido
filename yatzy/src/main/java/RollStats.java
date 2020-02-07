import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RollStats {

    private final List<Roll> _rolls;

    public RollStats(){
        _rolls = new ArrayList<>();
    }

     public void addRoll(Roll currentRoll){
        _rolls.add(currentRoll);
    }

    public Score calculateTotalScore() {
        Score total = new Score(0);
        for(Roll roll:_rolls) {
           total =  total.sum(roll.calculate());
        }
        return total;

    }
}
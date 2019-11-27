import org.junit.Assert;
import org.junit.Test;

public class TicTacToeShould {
    @Test
    public void returnTrueWhenXIsPassedAsFirstMove() {
        TicTacToe tictactoe = new TicTacToe();
        Assert.assertTrue(tictactoe.move("X"));
    }
}

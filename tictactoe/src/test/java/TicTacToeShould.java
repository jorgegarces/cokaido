import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TicTacToeShould {
    TicTacToe tictactoe;

    @Before
    public void setup(){
        tictactoe = new TicTacToe();
    }

    @Test
    public void ensureThatXPlaysFirst() {
        Assert.assertTrue(tictactoe.move("X", 0));
    }

    @Test
    public void ensureThatODoesNotPlayFirst() {
        Assert.assertFalse(tictactoe.move("O", 0));
    }

    @Test
    public void ensureThatSameMoveIsNotPlayedTwice(){
        tictactoe.move("X", 0);

        Assert.assertFalse(tictactoe.move("X", 0));
    }

    @Test
    public void ensureThatTheSamePositionIsNotUsedTwice() {
        tictactoe.move("X", 1);

        Assert.assertFalse(tictactoe.move("O", 1));
    }


}

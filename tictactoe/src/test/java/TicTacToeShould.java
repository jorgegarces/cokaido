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

        Assert.assertTrue(tictactoe.move("X"));
    }

    @Test
    public void ensureThatODoesNotPlayFirst() {

        Assert.assertFalse(tictactoe.move("O"));
    }

    @Test
    public void ensureThatSameMoveIsNotPlayedTwice(){

        tictactoe.move("X");
        Assert.assertFalse(tictactoe.move("X"));
    }
}

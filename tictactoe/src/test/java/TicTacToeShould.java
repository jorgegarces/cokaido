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

    @Test
    public void ensureThatTheXIsTheWinnerFirstLine(){
        tictactoe.move("X", 0);
        tictactoe.move("O", 3);
        tictactoe.move("X", 1);
        tictactoe.move("O", 6);
        tictactoe.move("X", 2);

        Assert.assertTrue(tictactoe.checkWinner());
    }

    @Test
    public void ensureThatTheXIsTheWinnerSecondLine(){
        tictactoe.move("X",3);
        tictactoe.move("O",6);
        tictactoe.move("X",4);
        tictactoe.move("O",1);
        tictactoe.move("X",5);

        Assert.assertTrue(tictactoe.checkWinner());
    }

    @Test
    public void ensureThatTheXIsTheWinnerThirdLine(){
        tictactoe.move("X",6);
        tictactoe.move("O",1);
        tictactoe.move("X",7);
        tictactoe.move("O",3);
        tictactoe.move("X",8);

        Assert.assertTrue(tictactoe.checkWinner());
    }

}

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TicTacToeShould {

    Tictactoe tictactoe;
    @Before
    public void setup(){
        tictactoe = new Tictactoe();
    }

    @Test
    public void ensure_X_is_passed_on_the_first_move(){

        Assert.assertEquals("O's turn", tictactoe.move("X"));
    }
}

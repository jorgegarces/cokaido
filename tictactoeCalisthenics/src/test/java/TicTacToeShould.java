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
    public void ensure_O_is_not_passed_on_the_first_move() {
        Assert.assertEquals(Response.NOTYOURTURN, tictactoe.move(Movement.O));
    }

    @Test
    public void ensure_alternate_moves(){
        tictactoe.move(Movement.X);

        Assert.assertEquals(Response.NOTYOURTURN, tictactoe.move(Movement.X));
    }
}

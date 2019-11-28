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
        Assert.assertEquals(Response.NOTYOURTURN, tictactoe.move(Movement.O, Cell.ZERO));
    }

    @Test
    public void ensure_alternate_moves(){
        tictactoe.move(Movement.X, Cell.TWO);

        Assert.assertEquals(Response.NOTYOURTURN, tictactoe.move(Movement.X, Cell.ZERO));
    }

    @Test(expected = RuntimeException.class)
    public void ensure_no_repeated_position(){
        tictactoe.move(Movement.X, Cell.ZERO);

        tictactoe.move(Movement.O, Cell.ZERO);

    }

    @Test
    public void ensure_game_ends_on_first_row_win(){

        tictactoe.move(Movement.X, Cell.ZERO);
        tictactoe.move(Movement.O, Cell.THREE);
        tictactoe.move(Movement.X, Cell.ONE);
        tictactoe.move(Movement.O, Cell.FOUR);

        Assert.assertEquals(Response.YOUWIN, tictactoe.move(Movement.X, Cell.TWO));
    }

}

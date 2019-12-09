import org.junit.Assert;
import org.junit.Test;

/**
 *  Generate a lonely cell, make sure it dies
 *  Generate a neighboured cell, make sure it lives
 */

public class GameOfLifeShould {
    @Test
    public void ensure_lonely_cells_die() {
        GameOfLife game = new GameOfLife();
        game.addLivingCell(0,0);
        game.runGame();

        GameOfLife expectedGame = new GameOfLife();

        Assert.assertTrue(expectedGame.equals(game));
    }
}
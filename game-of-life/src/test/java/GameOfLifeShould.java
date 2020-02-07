import org.junit.Assert;
import org.junit.Test;

import javax.management.monitor.GaugeMonitorMBean;

/**
 *  Generate a lonely cell, make sure it dies
 *  Test position already exists, throw exception if it does
 *  Generate a neighboured cell, make sure it lives
 */

public class GameOfLifeShould {
    @Test
    public void ensure_lonely_cells_die() {
        GameOfLife game = new GameOfLife();
        game.addLivingCell(new Cell(), new Position(0,0));
        game.runGame();
        GameOfLife expectedGame = new GameOfLife();

        Assert.assertTrue(expectedGame.equals(game));
    }

    @Test
    public void test(){
        GameOfLife game = new GameOfLife();
        game.addLivingCell(new Cell(), new Position(0,0));
        game.addLivingCell(new Cell(), new Position(0,1));
        game.addLivingCell(new Cell(), new Position(0,2));
        game.runGame();
        GameOfLife expectedGame = new GameOfLife();


        Assert.assertTrue(expectedGame.equals(game));
    }
}
import org.junit.Assert;
import org.junit.Test;

public class PacManShould {

    @Test
    public void ensure_pacman_moves_right() {
        PacMan pacman = new PacMan();

        pacman.moveRight();

        Assert.assertEquals(new PacMan(0,1),pacman);
    }

    @Test
    public void ensure_pacman_moves_down(){
        PacMan pacman = new PacMan();

        pacman.moveDown();

        Assert.assertEquals(new PacMan(1,0),pacman);
    }

    @Test
    public void ensure_pacman_moves_left(){
        PacMan pacman = new PacMan(1,1);

        pacman.moveLeft();

        Assert.assertEquals(new PacMan(1,0),pacman);
    }
}

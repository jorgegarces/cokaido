import org.junit.Assert;
import org.junit.Test;

public class PacManShould {

    @Test
    public void ensure_pacman_moves_right() {
        PacMan pacman = new PacMan();

        pacman.moveRight();

        Assert.assertEquals(new PacMan(0,1),pacman);
    }
}

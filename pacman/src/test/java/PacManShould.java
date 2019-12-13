import org.junit.Assert;
import org.junit.Test;
/*
*
*
 */
public class PacManShould {

    @Test
    public void ensure_pacman_moves_right_and_looks_right() {
        PacMan pacman = new PacMan(0,0, Direction.LEFT);

        pacman.move(Cell.EMPTY, Move.RIGHT);

        Assert.assertEquals(new PacMan(1,0, Direction.RIGHT), pacman);
    }

    @Test
    public void ensure_pacman_moves_left_and_looks_left() {
        PacMan pacman = new PacMan(0, 0, Direction.RIGHT);

        pacman.move(Cell.EMPTY, Move.LEFT);

        Assert.assertEquals(new PacMan(-1, 0, Direction.LEFT), pacman);
    }

    @Test
    public void ensure_pacman_moves_up_and_looks_up() {
        PacMan pacman = new PacMan(0,0, Direction.RIGHT);

        pacman.move(Cell.EMPTY, Move.UP);

        Assert.assertEquals(new PacMan(0,1, Direction.UP), pacman);
    }

    @Test
    public void ensure_pacman_moves_down_and_looks_down() {
        PacMan pacman = new PacMan(0, 0, Direction.DOWN);

        pacman.move(Cell.EMPTY, Move.DOWN);

        Assert.assertEquals(new PacMan(0, -1, Direction.DOWN), pacman);
    }

    @Test
    public void ensure_pacman_does_not_move_through_walls_when_moving_right() {
        PacMan pacman = new PacMan(0,0, Direction.RIGHT);

        pacman.move(Cell.WALL, Move.RIGHT);

        Assert.assertEquals(new PacMan(0,0, Direction.RIGHT), pacman);
    }

    @Test
    public void ensure_pacman_does_not_move_through_walls_when_moving_left() {
        PacMan pacman = new PacMan(0,0, Direction.LEFT);

        pacman.move(Cell.WALL, Move.LEFT);

        Assert.assertEquals(new PacMan(0,0, Direction.LEFT), pacman);
    }

    @Test
    public void ensure_pacman_does_not_move_through_walls_when_moving_up() {
        PacMan pacman = new PacMan(0,0, Direction.UP);

        pacman.move(Cell.WALL, Move.UP);

        Assert.assertEquals(new PacMan(0,0, Direction.UP), pacman);
    }

    @Test
    public void ensure_pacman_does_not_move_through_walls_when_moving_down() {
        PacMan pacman = new PacMan(0,0, Direction.DOWN);

        pacman.move(Cell.WALL, Move.DOWN);

        Assert.assertEquals(new PacMan(0,0, Direction.DOWN), pacman);
    }

    @Test
    public void ensure_pacman_always_leaves_an_empty_cell_behind() {
        PacMan pacman = new PacMan(0,0, Direction.DOWN);

        Cell destination = Cell.DOT;
        Cell origin = pacman.move(destination, Move.DOWN);

        Assert.assertEquals(Cell.EMPTY, origin);
    }


}

import org.junit.Assert;
import org.junit.Test;

public class MarsRoverShould {
    @Test
    public void default_to_00N_as_initial_position() {
        MarsRover marsRover = new MarsRover();
        MarsRover expected = new MarsRover(0,0,'N');

        Assert.assertEquals(expected, marsRover);
    }
}

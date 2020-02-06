import org.junit.Assert;
import org.junit.Test;

public class MarsRoverShould {
    @Test
    public void default_to_00N_as_initial_position() {
        MarsRover marsRover = new MarsRover();
        MarsRover expected = new MarsRover(0,0,'N');

        Assert.assertEquals(expected, marsRover);
    }
    @Test
    public void navigates_north_when_F_instruction_is_passed_from_starter_position(){
        MarsRover marsRover = new MarsRover();
        marsRover.navigate('F');
        MarsRover expected = new MarsRover(0, 1,'N');

        Assert.assertEquals(expected, marsRover );
    }
}

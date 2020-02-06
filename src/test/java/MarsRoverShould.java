import org.junit.Assert;
import org.junit.Test;

public class MarsRoverShould {
    @Test
    public void default_to_00N_as_initial_position() {
        MarsRover marsRover = new MarsRover();
        MarsRover expected = new MarsRover(0, 0, 'N');

        Assert.assertEquals(expected, marsRover);
    }

    @Test
    public void navigates_north_when_F_instruction_is_passed_from_starter_position() {
        MarsRover marsRover = new MarsRover();
        marsRover.navigate('F');
        MarsRover expected = new MarsRover(0, 1, 'N');

        Assert.assertEquals(expected, marsRover);
    }

    @Test
    public void navigates_north_when_F_instruction_if_orientation_is_north() {
        MarsRover marsRover = new MarsRover(0, 1, 'N');
        marsRover.navigate('F');
        MarsRover expected = new MarsRover(0, 2, 'N');

        Assert.assertEquals(expected, marsRover);
    }

    @Test
    public void navigates_east_when_F_instruction_if_orientation_is_east(){
        MarsRover marsRover = new MarsRover(0,0,'E');
        marsRover.navigate('F');
        MarsRover expected = new MarsRover(1,0,'E');

        Assert.assertEquals(expected, marsRover);
    }

    @Test
    public void navigates_south_when_F_instruction_if_orientation_is_south(){
        MarsRover marsRover = new MarsRover(0,0,'S');
        marsRover.navigate('F');
        MarsRover expected = new MarsRover(0,-1,'S');
        Assert.assertEquals(expected, marsRover);
    }
    
    @Test
    public void navigates_west_when_F_instruction_if_orientation_is_west(){
        MarsRover marsRover = new MarsRover(0,0,'W');
        marsRover.navigate('F');
        MarsRover expected = new MarsRover(-1, 0, 'W');
        Assert.assertEquals(expected, marsRover);
    }
}

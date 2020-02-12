import com.sun.tools.javac.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import rover.Rover;
import rover.RoverNormal;

public class RoverShould {
    @Test
    public void decrease_roverNormal_fuel_level_by_one_when_moving_forward() {
        Rover rover = new RoverNormal(0,0,'N');
        rover.moveForward();
        Assertions.assertTrue(rover.checkFuel(99));
    }

    @Test
    public void decreases_roverNormal_fuel_level_by_1_when_moving_backwards(){
        Rover rover = new RoverNormal();
        rover.moveBackwards();
        Assertions.assertTrue(rover.checkFuel(99));
    }

}

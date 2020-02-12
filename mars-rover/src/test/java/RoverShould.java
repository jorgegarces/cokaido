import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import rover.Land;
import rover.Rover;
import rover.RoverNormal;
import rover.RoverState;

public class RoverShould {
    @Test
    public void decrease_roverNormal_battery_level_by_one_when_moving_forward() {
        Rover rover = new RoverNormal(0,0,'N');
        rover.moveForward();
        Assertions.assertTrue(rover.checkBattery(99));
    }

    @Test
    public void decreases_roverNormal_battery_level_by_1_when_moving_backwards(){
        Rover rover = new RoverNormal();
        rover.moveBackwards();
        Assertions.assertTrue(rover.checkBattery(99));
    }

    @Test
    public void decreases_battery_level_by_1_when_rotating_left(){
        Rover rover = new RoverNormal();
        rover.rotateLeft();
        Assertions.assertTrue(rover.checkBattery(99));
    }
    @Test
    public void decreases_battery_level_by_1_when_rotating_right(){
        Rover rover = new RoverNormal();
        rover.rotateRight();
        Assertions.assertTrue(rover.checkBattery(99));
    }
    @Test
    public void rover_normal_default_state_is_Land() {
        Rover rover = new RoverNormal();
        RoverState land = new Land();
        Assertions.assertTrue(rover.checkState(land));
    }

}

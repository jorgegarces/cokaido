import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import rover.*;

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
    public void default_state_is_ground() {
        Rover rover = new RoverNormal();
        Assertions.assertTrue(rover.checkState(new Ground()));
    }

    @Test
    public void take_off_from_the_ground() {
        Rover rover = new RoverNormal();

        rover.fly();

        Assertions.assertTrue(rover.checkState(new Air()));
    }
    @Test
    public void burrow_from_the_surface() {
        Rover rover = new RoverNormal();

        rover.dig();

        Assertions.assertTrue(rover.checkState(new Underground()));
    }
    @Test
    public void take_off_and_land() {
        Rover rover = new RoverNormal();

        rover.fly();
        rover.land();

        Assertions.assertTrue(rover.checkState(new Ground()));
    }

    @Test
    public void spend_two_energy_when_flying_forward() {
        Rover rover = new RoverNormal();

        rover.fly();
        rover.moveForward();

        Assertions.assertTrue(rover.checkBattery(98));
    }

}

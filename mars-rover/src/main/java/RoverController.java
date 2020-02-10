import navCommands.Command;
import position.Rover;

import java.util.Objects;

public class RoverController {

    private final Rover rover;

    public RoverController() {
        rover = new Rover(0, 0, 'N');
    }

    public RoverController(int latitude, int longitude, char orientation) {
        rover = new Rover(latitude, longitude, orientation);
    }

    public void navigate(String movement) {
        for (int i = 0; i < movement.length(); i++) {
            run(Command.create(movement.charAt(i), rover));
        }
    }

    private void run(Command command) {
        command.execute();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoverController roverController = (RoverController) o;
        return Objects.equals(rover, roverController.rover);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rover);
    }
}

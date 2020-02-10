import navCommands.Command;
import rover.Rover;

import java.util.Objects;

public class RoverController {

    private final Rover rover;

    public RoverController(Rover rover) {
        this.rover = rover;
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
        RoverController that = (RoverController) o;
        return Objects.equals(rover, that.rover);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rover);
    }

    @Override
    public String toString() {
        return "RoverController{" +
                "rover=" + rover +
                '}';
    }
}


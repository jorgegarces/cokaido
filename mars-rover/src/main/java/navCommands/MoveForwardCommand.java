package navCommands;

import rover.Rover;

public class MoveForwardCommand extends Command {


    protected MoveForwardCommand(Rover rover) {
      super(rover);
    }

    @Override
    public void execute() {
        this.rover.moveForward();
    }
}

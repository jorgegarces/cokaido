package navCommands;

import position.Rover;

public class RotateLeftCommand extends Command {
    protected RotateLeftCommand(Rover rover) {
        super(rover);
    }

    @Override
    public void execute() {
        rover.rotateLeft();
    }
}

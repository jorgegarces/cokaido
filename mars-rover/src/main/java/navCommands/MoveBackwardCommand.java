package navCommands;

import position.Rover;

public class MoveBackwardCommand extends Command {
    protected MoveBackwardCommand(Rover rover) {
        super(rover);
    }

    @Override
    public void execute() {
        rover.moveBackwards();
    }
}

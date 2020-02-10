package navCommands;

import position.Position;

public class RotateRightCommand extends Command {

    protected RotateRightCommand(Position position) {
        super(position);
    }

    @Override
    public void execute() {
        position.rotateRight();
    }
}

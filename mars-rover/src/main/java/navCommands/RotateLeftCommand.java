package navCommands;

import position.Position;

public class RotateLeftCommand extends Command {
    protected RotateLeftCommand(Position position) {
        super(position);
    }

    @Override
    public void execute() {
        position.rotateLeft();
    }
}

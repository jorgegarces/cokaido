package navCommands;

import position.Position;

public class MoveBackwardCommand extends Command {
    protected MoveBackwardCommand(Position position) {
        super(position);
    }

    @Override
    public void execute() {
        position.moveBackwards();
    }
}

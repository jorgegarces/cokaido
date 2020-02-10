package navCommands;

import position.Position;

public class MoveForwardCommand extends Command {


    protected MoveForwardCommand(Position position) {
      super(position);
    }

    @Override
    public void execute() {
        this.position.moveForward();
    }
}

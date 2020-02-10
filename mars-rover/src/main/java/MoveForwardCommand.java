public class MoveForwardCommand extends Command {


    protected MoveForwardCommand(Position position) {
      super(position);
    }

    @Override
    protected void execute() {
        this.position.moveForward();
    }
}

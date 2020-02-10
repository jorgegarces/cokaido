public class MoveBackwardCommand extends Command {
    protected MoveBackwardCommand(Position position) {
        super(position);
    }

    @Override
    protected void execute() {
        position.moveBackwards();
    }
}

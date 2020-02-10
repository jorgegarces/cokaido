public class RotateLeftCommand extends Command {
    protected RotateLeftCommand(Position position) {
        super(position);
    }

    @Override
    protected void execute() {
        position.rotateLeft();
    }
}

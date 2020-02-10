public class RotateRightCommand extends Command {

    protected RotateRightCommand(Position position) {
        super(position);
    }

    @Override
    protected void execute() {
        position.rotateRight();
    }
}

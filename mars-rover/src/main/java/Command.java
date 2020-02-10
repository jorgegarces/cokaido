public abstract class Command {
    protected final Position position;

    public Command(Position position) {
        this.position = position;
    }

    public static Command create(char command, Position position) {
        if (command == 'F') return new MoveForwardCommand(position);
        if (command == 'B') return new MoveBackwardCommand(position);
        if (command == 'L') return new RotateLeftCommand(position);
        if (command == 'R') return new RotateRightCommand(position);
        return null;
    }

    abstract protected void execute();
}
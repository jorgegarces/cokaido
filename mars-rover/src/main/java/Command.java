public class Command {
    private final char command;

    public Command(char command) {
        this.command = command;
    }

    public void execute(Position position) {
        if (command == 'F') position.moveForward();
        if (command == 'R') position.rotateRight();
        if (command == 'L') position.rotateLeft();
        if (command == 'B') position.moveBackwards();
    }
}

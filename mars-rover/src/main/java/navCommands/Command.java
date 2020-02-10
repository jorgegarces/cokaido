package navCommands;

import position.Rover;

public abstract class Command {
    protected final Rover rover;

    public Command(Rover rover) {
        this.rover = rover;
    }

    public static Command create(char command, Rover rover) {
        if (command == 'F') return new MoveForwardCommand(rover);
        if (command == 'B') return new MoveBackwardCommand(rover);
        if (command == 'L') return new RotateLeftCommand(rover);
        if (command == 'R') return new RotateRightCommand(rover);
        return null;
    }

    public abstract void execute();
}
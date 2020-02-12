package rover;

import orientation.East;
import orientation.North;
import orientation.South;
import orientation.West;

public class RoverNormal extends Rover {

    public RoverNormal() {
        super();
    }

    public RoverNormal(int latitude, int longitude, char orientation) {
        super(latitude, longitude, orientation);
    }

    @Override
    public void moveForward() {
        if (orientation instanceof North) longitude++;
        if (orientation instanceof East) latitude++;
        if (orientation instanceof South) longitude--;
        if (orientation instanceof West) latitude--;
        fuel--;
    }

    @Override
    public void moveBackwards() {
        if (orientation instanceof North) longitude--;
        if (orientation instanceof East) latitude--;
        if (orientation instanceof South) longitude++;
        if (orientation instanceof West) latitude++;
        fuel--;
    }

}

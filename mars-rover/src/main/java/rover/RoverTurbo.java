package rover;

import orientation.East;
import orientation.North;
import orientation.South;
import orientation.West;

public class RoverTurbo extends Rover {

    public RoverTurbo() {
        super();
    }
    public RoverTurbo(int latitude, int longitude, char orientation) {
        super(latitude, longitude, orientation);
    }
    @Override
    public void moveForward() {
        if (this.orientation instanceof North) longitude+=2;
        if (orientation instanceof East) latitude+=2;
        if (orientation instanceof South) longitude-=2;
        if (orientation instanceof West) latitude-=2;
    }

    @Override
    public void moveBackwards() {
        if (orientation instanceof North) longitude-=2;
        if (orientation instanceof East) latitude-=2;
        if (orientation instanceof South) longitude+=2;
        if (orientation instanceof West) latitude+=2;
    }
}

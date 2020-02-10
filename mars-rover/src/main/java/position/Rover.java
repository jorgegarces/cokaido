package position;

import orientation.*;

import java.util.Objects;

public class Rover {

    private Orientation orientation;
    private int latitude;
    private int longitude;

    public Rover(int latitude, int longitude, char orientation) {

        this.latitude = latitude;
        this.longitude = longitude;
        this.orientation = Orientation.create(orientation);
    }

    public void rotateLeft() {
        this.orientation = orientation.rotateLeft();
    }

    public void rotateRight() {
        this.orientation = orientation.rotateRight();
    }

    public void moveForward() {
        if (orientation instanceof North) longitude++;
        if (orientation instanceof East) latitude++;
        if (orientation instanceof South) longitude--;
        if (orientation instanceof West) latitude--;
    }

    public void moveBackwards() {
        if (orientation instanceof North) longitude--;
        if (orientation instanceof East) latitude--;
        if (orientation instanceof South) longitude++;
        if (orientation instanceof West) latitude++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rover rover = (Rover) o;
        return latitude == rover.latitude &&
                longitude == rover.longitude &&
                rover.orientation.getClass() == this.orientation.getClass();
    }

    @Override
    public int hashCode() {
        return Objects.hash(orientation, latitude, longitude);
    }
}
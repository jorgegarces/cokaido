package rover;

import orientation.*;

import java.util.Objects;

public abstract class Rover {

    protected Orientation orientation;
    protected int latitude;
    protected int longitude;

    public Rover(int latitude, int longitude, char orientation) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.orientation = Orientation.create(orientation);
    }

    public Rover() {
        this.latitude = 0;
        this.longitude = 0;
        this.orientation = new North();
    }


    public void rotateLeft() {
        this.orientation = orientation.rotateLeft();
    }

    public void rotateRight() {
        this.orientation = orientation.rotateRight();
    }

    public abstract void moveForward();

    public abstract void moveBackwards();

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
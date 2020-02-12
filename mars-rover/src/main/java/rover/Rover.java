package rover;

import orientation.*;

import java.util.Objects;

public abstract class Rover {

    protected final Battery battery;
    protected Orientation orientation;
    protected int latitude;
    protected int longitude;
    private Context context;

    public Rover(int latitude, int longitude, char orientation) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.orientation = Orientation.create(orientation);
        this.battery = new Battery();
        this.context = new Context();
    }

    public Rover() {
        this.latitude = 0;
        this.longitude = 0;
        this.orientation = new North();
        this.battery = new Battery();
        this.context = new Context();
    }


    public void rotateLeft() {
        this.orientation = orientation.rotateLeft();
        this.battery.decreaseBatteryLevel();
    }


    public void rotateRight() {
        this.orientation = orientation.rotateRight();
        this.battery.decreaseBatteryLevel();
    }

    public abstract void moveForward();

    public abstract void moveBackwards();

    public void fly(){
        this.context.setState(new Air());
    }

    public boolean checkBattery(int chargeLevel) {
        return this.battery.checkLevel(chargeLevel);
    }

    public boolean checkState(RoverState state) {
        return this.context.getState().getClass() == state.getClass();
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


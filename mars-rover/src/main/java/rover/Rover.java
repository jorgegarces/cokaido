package rover;

import orientation.*;

import java.util.Objects;

public abstract class Rover {

    protected Orientation orientation;
    protected int latitude;
    protected int longitude;
    protected EngineManager engineManager;

    public Rover(int latitude, int longitude, char orientation) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.orientation = Orientation.create(orientation);
        this.engineManager = new EngineManager(new Battery());
    }

    public Rover() {
        this.latitude = 0;
        this.longitude = 0;
        this.orientation = new North();
        this.engineManager = new EngineManager(new Battery());
    }

    public void rotateLeft() {
        this.engineManager.supplyEnergy();
        this.orientation = orientation.rotateLeft();
    }

    public void rotateRight() {
        this.engineManager.supplyEnergy();
        this.orientation = orientation.rotateRight();
    }

    public abstract void moveForward();

    public abstract void moveBackwards();

    public void fly(){
        this.engineManager.useEngine(new Air());
    }

    public void dig() {
        this.engineManager.useEngine(new Underground());
    }

    public void land(){
        this.engineManager.useEngine(new Ground());
    }

    public boolean checkBattery(int chargeLevel) {
        return this.engineManager.checkLevel(chargeLevel);
    }

    public boolean checkState(RoverEngine state) {
        return this.engineManager.getState().getClass() == state.getClass();
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


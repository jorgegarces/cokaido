package rover;

public class EngineManager {
    RoverEngine state;
    Battery battery;

    public EngineManager(Battery battery) {
        this.state = new Ground();
        this.battery = battery;
    }

    public void useEngine(RoverEngine newState) {
        this.state = newState;
    }

    public RoverEngine getState() {
        return state;
    }

    public void supplyEnergy() {
        this.state.loadEnergy(this.battery);
    }

    public boolean checkLevel(int chargeLevel) {
        return this.battery.checkLevel(chargeLevel);
    }
}

package rover;

public class EngineManager {
    RoverEngine engine;
    Battery battery;

    public EngineManager(Battery battery) {
        this.engine = new Ground();
        this.battery = battery;
    }

    public void useEngine(RoverEngine newEngine) {
        this.engine = newEngine;
    }

    public void supplyEnergy() {
        this.engine.loadEnergy(this.battery);
    }

    public boolean checkLevel(int chargeLevel) {
        return this.battery.checkLevel(chargeLevel);
    }

    public boolean engineInUse(RoverEngine engine) {
        return this.engine.getClass() == engine.getClass();
    }
}

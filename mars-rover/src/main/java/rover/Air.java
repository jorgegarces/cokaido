package rover;

public class Air implements RoverEngine {
    @Override
    public void loadEnergy(Battery battery) {
        battery.extractEnergy(2);
    }
}

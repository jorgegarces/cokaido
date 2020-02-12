package rover;

public class Ground implements RoverEngine {
    @Override
    public void loadEnergy(Battery battery) {
        battery.extractEnergy(1);
    }
}

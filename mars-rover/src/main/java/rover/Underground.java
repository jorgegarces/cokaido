package rover;

public class Underground implements RoverEngine {
    @Override
    public void loadEnergy(Battery battery) {
        battery.extractEnergy(3);
    }
}

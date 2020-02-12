package rover;

public class Battery {
    private int chargeLevel;

    public Battery() {
        this.chargeLevel = 100;
    }

    void decreaseBatteryLevel() {
        chargeLevel--;
    }

    boolean checkLevel(int chargeLevel) {
        return this.chargeLevel == chargeLevel;
    }
}
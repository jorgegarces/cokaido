package rover;

public class Battery {
    private int chargeLevel;

    public Battery() {
        this.chargeLevel = 100;
    }

    void extractEnergy(int energy) {
        chargeLevel-= energy;
    }

    boolean checkLevel(int chargeLevel) {
        return this.chargeLevel == chargeLevel;
    }
}
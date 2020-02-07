public class NaturalNumber {

    private int naturalNumber;

    public NaturalNumber(int naturalNumber) {
        this.naturalNumber = naturalNumber;
    }

    public BinaryNumber toBinary() {
        StringBuilder converted = new StringBuilder();

        if (this.naturalNumber == 0) return new BinaryNumber("0");

        while (this.naturalNumber > 0) {
            converted.insert(0, getLastBitFromValue(this.naturalNumber));
            this.naturalNumber = this.naturalNumber / 2;
        }
        return new BinaryNumber(converted.toString());
    }

    private static int getLastBitFromValue(int value) {
        return value % 2;
    }
}
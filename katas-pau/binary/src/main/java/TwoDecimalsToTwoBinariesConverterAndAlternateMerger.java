public class TwoDecimalsToTwoBinariesConverterAndAlternateMerger {

    public static String merge(int decimal1, int decimal2) {
        StringBuilder meh = new StringBuilder();

        if (decimal2 == 0 && decimal1 == 0) return "00";

        while (decimal1 > 0 || decimal2 > 0) {
            meh.insert(0, getLastBitFromValue(decimal2));
            meh.insert(0, getLastBitFromValue(decimal1));

            decimal1 = decimal1 / 2;
            decimal2 = decimal2 / 2;
        }
        return meh.toString();
    }

    private static int getLastBitFromValue(int value) {
        return value % 2;
    }
}
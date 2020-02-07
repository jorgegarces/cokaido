import java.util.Arrays;

public class Table {
    public static double[] intersection(double[] v1, double[] v2) {

        double[] tempArray;
        int position = 0;

        if (v1.length < v2.length) tempArray = new double[v1.length];
        else tempArray = new double[v2.length];

        int i = 0;
        int j = 0;

        while (i < v1.length && j < v2.length) {
            if (v1[i] < v2[j]) i++;
            else if (v1[i] > v2[j]) j++;

            else if (v1[i] == v2[j]) {

                if (position == 0 || v1[i] != tempArray[position - 1]) {
                    tempArray[position] = v1[i];
                    position++;
                }
                i++;
                j++;
            }
        }
        return Arrays.copyOfRange(tempArray, 0, position);
    }
}
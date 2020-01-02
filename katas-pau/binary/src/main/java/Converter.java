import java.math.BigInteger;

public class Converter {

    public String binaryNumberAsAString = "";
    BigInteger binaryNumber;

    public BigInteger merge(int decimal1, int decimal2) {
        String binary1 = Integer.toBinaryString(decimal1);
        String binary2 = Integer.toBinaryString(decimal2);
        int size = binary1.length();

        for(int i = 0; i < size; i++) {
            binaryNumberAsAString += binary1.charAt(i);
            binaryNumberAsAString += binary2.charAt(i);
        }

        binaryNumber = new BigInteger(binaryNumberAsAString);
        return binaryNumber;
    }
}
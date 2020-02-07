import java.util.Objects;

public class BinaryNumber {

    String value;

    public BinaryNumber(String binaryAsAString) {
        this.value = binaryAsAString;
    }

    static BinaryNumber alternatingMerge(BinaryNumber binary1, BinaryNumber binary2) {
        StringBuilder merged = new StringBuilder();

        for(int i = 0; i < binary1.value.length(); i++) {
            merged.append(binary1.value.charAt(i));
            merged.append(binary2.value.charAt(i));
        }
        return new BinaryNumber(merged.toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BinaryNumber that = (BinaryNumber) o;
        return Objects.equals(value, that.value);
    }
}
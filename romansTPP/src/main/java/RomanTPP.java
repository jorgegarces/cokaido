import java.util.HashMap;

public class RomanTPP {
    public String convert(int arabicNumber) {

        if (arabicNumber == 1) return "I";

        if (arabicNumber < 4) return "I" + convert(arabicNumber - 1);

        if (arabicNumber == 5) return "V";

        if (arabicNumber < 9) return "V" + convert(arabicNumber - 5);

        HashMap<Integer, String> dictionaryOfRomanNumbers = new HashMap<Integer, String>();

        dictionaryOfRomanNumbers.put(4, "IV");

        return dictionaryOfRomanNumbers.get(arabicNumber);
    }
}
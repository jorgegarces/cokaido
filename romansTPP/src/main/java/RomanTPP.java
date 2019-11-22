import java.util.HashMap;

public class RomanTPP {
    public String convert(int arabicNumber) {

        if (arabicNumber == 1) return "I";

        if (arabicNumber < 4) return "I" + convert(arabicNumber - 1);

        HashMap<Integer, String> dictionaryOfRomanNumbers = new HashMap<Integer, String>();

        dictionaryOfRomanNumbers.put(4, "IV");
        dictionaryOfRomanNumbers.put(5, "V");
        dictionaryOfRomanNumbers.put(6, "VI");
        dictionaryOfRomanNumbers.put(7, "VII");
        dictionaryOfRomanNumbers.put(8, "VIII");


        return dictionaryOfRomanNumbers.get(arabicNumber);
    }
}
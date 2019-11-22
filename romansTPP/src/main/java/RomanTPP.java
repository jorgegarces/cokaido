import java.util.HashMap;

public class RomanTPP {
    public String convert(int arabicNumber) {
        HashMap<Integer, String> dictionaryOfRomanNumbers = new HashMap<Integer, String>();
        dictionaryOfRomanNumbers.put(1, "I");
        dictionaryOfRomanNumbers.put(2, "II");
        dictionaryOfRomanNumbers.put(3, "III");
        dictionaryOfRomanNumbers.put(4, "IV");
        dictionaryOfRomanNumbers.put(5, "V");
        dictionaryOfRomanNumbers.put(6, "VI");
        return dictionaryOfRomanNumbers.get(arabicNumber);
    }
}
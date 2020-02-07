import java.util.HashMap;

public class RomanTPP {

    HashMap<Integer, String> dictionaryOfRomanNumbers = new HashMap<Integer, String>();

    public RomanTPP (){

        dictionaryOfRomanNumbers.put(1, "I");
        dictionaryOfRomanNumbers.put(4, "IV");
        dictionaryOfRomanNumbers.put(5, "V");
        dictionaryOfRomanNumbers.put(9, "IX");
        dictionaryOfRomanNumbers.put(10, "X");
        dictionaryOfRomanNumbers.put(40, "XL");
        dictionaryOfRomanNumbers.put(50, "L");
    }

    public String convert(int arabicNumber) {

        if (dictionaryOfRomanNumbers.containsKey(arabicNumber)) return dictionaryOfRomanNumbers.get(arabicNumber);

        if (arabicNumber > 50) return dictionaryOfRomanNumbers.get(50) + convert(arabicNumber -50);

        if (arabicNumber > 10) return dictionaryOfRomanNumbers.get(10) + convert(arabicNumber -10);

        if (arabicNumber > 5) return dictionaryOfRomanNumbers.get(5) + convert(arabicNumber - 5);


        return dictionaryOfRomanNumbers.get(1) + convert(arabicNumber -1 );
    }
}
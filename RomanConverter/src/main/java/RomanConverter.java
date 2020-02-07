import java.util.HashMap;
import java.util.HashSet;

public class RomanConverter {

    public String convert(int arabicNumber) {

        HashMap<Integer, String> arabicRomanNumbers = new HashMap<Integer, String>()
        {
            {
            put(1,"I");
            put(5,"V");
            put(10, "X");
            put(50,"L");
            put(100,"C");
            put(500,"D");
            put(1000,"M");
            }
        };
        if (arabicRomanNumbers.containsKey(arabicNumber)) return arabicRomanNumbers.get(arabicNumber);

        String[] decomposeNumbers = (arabicNumber+"").split("");
        int index = 0;
        for(String number : decomposeNumbers){
            Integer key = (int) Math.pow(10, decomposeNumbers.length - (index +1));
            String symbol = arabicRomanNumbers.get(key);
            new String(new char[number]).replace("\0", arabicRomanNumbers.get());
        }
        if (arabicNumber < 4)
            return new String(new char[arabicNumber]).replace("\0", arabicRomanNumbers.get(1));
        if (arabicNumber < 9)
            return "V" + new String(new char[arabicNumber - 5]).replace("\0", arabicRomanNumbers.get(1));
        if (arabicNumber < 14)
            return "X" + new String(new char[arabicNumber -10]).replace("\0", arabicRomanNumbers.get(1));
        if (arabicNumber < 19)
            return "XV" + new String(new char[arabicNumber -15]).replace("\0", arabicRomanNumbers.get(1));
        return "";
    }
}

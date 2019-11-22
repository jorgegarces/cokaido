public class RomanTPP {
    public String convert(int arabicNumber) {
        if (arabicNumber == 4) return "IV";
        return new String(new char[arabicNumber]).replace("\0", "I");
    }
}
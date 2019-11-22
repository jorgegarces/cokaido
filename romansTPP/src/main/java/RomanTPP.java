public class RomanTPP {
    public String convert(int arabicNumber) {
        if (arabicNumber == 4) return "IV";
        if (arabicNumber == 5) return "V";
        if (arabicNumber == 6) return "VI";
        return new String(new char[arabicNumber]).replace("\0", "I");
    }
}
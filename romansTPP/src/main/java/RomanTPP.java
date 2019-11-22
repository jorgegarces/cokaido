public class RomanTPP {
    public String convert(int arabicNumber) {
        return new String(new char[arabicNumber]).replace("\0", "I");
    }
}
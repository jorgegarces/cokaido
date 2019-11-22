public class RomanTPP {
    public String convert(int arabicNumber) {
        String[] romanNumbers = {"I","II","III","IV","V","VI"};
        return romanNumbers[arabicNumber - 1];
    }
}
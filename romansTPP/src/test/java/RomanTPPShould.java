import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class RomanTPPShould {
    @Test
    @Parameters({
            "1,I",
            "2,II",
            "3,III",
            "4,IV",
            "5,V",
            "6,VI",
            "7,VII",
            "8,VIII",
            "9,IX",
            "10,X",
            "11,XI",
            "33,XXXIII",
            "40,XL",
            "50,L",
            "52,LII"
    })
    public void return_roman_number_when_arabic_number_is_passed(int arabicNumber, String romanNumber){

        RomanTPP romanTPP = new RomanTPP();

        Assert.assertEquals(romanNumber, romanTPP.convert(arabicNumber));
    }
}

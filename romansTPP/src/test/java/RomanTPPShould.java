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
            "5,V"
    })
    public void return_roman_number_when_arabic_number_is_passed(int arabicNumber, String romanNumber){

        RomanTPP romanTPP = new RomanTPP();

        Assert.assertEquals(romanNumber, romanTPP.convert(arabicNumber));
    }
}

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class RomanConverterShould {

    RomanConverter romanConverter;
    @Before
    public void setup() {
        romanConverter = new RomanConverter();
    }

    @Test
    @Parameters({
            "1,I",
            "5,V",
            "10,X",
            "50,L",
            "100,C",
            "500,D",
            "1000,M"
    })
    public void returnRomanNumberWhenArabicNumberIsPassed(int arabic, String romanNumber) {
        Assert.assertEquals(romanNumber, romanConverter.convert(arabic));
    }

    @Test
    @Parameters({
            "2,II",
            "3,III",
            "6,VI"
    })
    public void returnRomanNumberWhenArabicNumberIsPassedSumCase(int arabic, String romanNumber){
        Assert.assertEquals(romanNumber, romanConverter.convert(arabic));
    }

    @Test
    @Parameters({
            "11,XI",
            "12,XII",
            "13,XIII",
            "16,XVI",
            "17,XVII",
            "18,XVIII"
    })
    public void returnRomanNumberWhenArabicNumberIsPassedSumCaseTen(int arabic, String romanNumber) {
        Assert.assertEquals(romanNumber, romanConverter.convert(arabic));
    }




}
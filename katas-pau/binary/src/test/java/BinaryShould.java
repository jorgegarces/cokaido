import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)

public class BinaryShould {
    @Test
    @Parameters({
            "1,1, 11",
            "8,15, 11010101",
            "2,3, 1101",
            "1000,600, 11101011100111000000",
            "900000,1000000, 1111011110011010100011101001100000000000",
            "0,0, 00",
            "0,1, 01"
    })

    public void work_with_a_long_ass_named_method(int decimal1, int decimal2, String expected){
        Assert.assertEquals(expected, TwoDecimalsToTwoBinariesConverterAndAlternateMerger.merge(decimal1, decimal2));
    }

    @Test
    @Parameters({
            "2, 10",
            "15, 1111",
            "0, 0",
            "1, 1"
    })

    public void correctly_convert_a_natural_number_to_binary(int natural, String expected) {
        Assert.assertEquals(new BinaryNumber(expected), new NaturalNumber(natural).toBinary());
    }

    @Test
    @Parameters({
            "8,15, 11010101",
            "2,3, 1101",
            "1000,600, 11101011100111000000",
            "900000,1000000, 1111011110011010100011101001100000000000",
            "0,0, 00",
            "0,1, 01"
    })

    public void merge_two_binaries_alternating_their_elements(int natural1, int natural2, String expected) {
        BinaryNumber binary1 = new NaturalNumber(natural1).toBinary();
        BinaryNumber binary2 = new NaturalNumber(natural2).toBinary();
        Assert.assertEquals(new BinaryNumber(expected), BinaryNumber.alternatingMerge(binary1, binary2));
    }
}
import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

public class BinaryShould {
    @Test
    public void work_with_two_ones(){
        BigInteger expected = new BigInteger("11");
        Assert.assertEquals(expected, new Converter().merge(1, 1));
    }

    @Test
    public void work_with_an_eight_and_a_fifteen(){
        BigInteger expected = new BigInteger("11010101");
        Assert.assertEquals(expected, new Converter().merge(8, 15));
    }

    @Test
    public void work_with_a_two_and_a_three(){
        BigInteger expected = new BigInteger("1101");
        Assert.assertEquals(expected, new Converter().merge(2, 3));
    }

    @Test
    public void work_with_a_thousand_and_a_sixhundred(){
        BigInteger expected = new BigInteger("11101011100111000000");
        Assert.assertEquals(expected, new Converter().merge(1000, 600));
    }

    @Test
    public void work_with_a_900000_and_a_1000000(){
        BigInteger expected = new BigInteger("1111011110011010100011101001100000000000");
        Assert.assertEquals(expected, new Converter().merge(900000, 1000000));
    }

    @Test
    public void work_with_two_zeroes(){
        BigInteger expected = new BigInteger("00");
        Assert.assertEquals(expected, new Converter().merge(0, 0));
    }
}
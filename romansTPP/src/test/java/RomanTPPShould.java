import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class RomanTPPShould {
    @Test
   /*   @Parameters({
           "1,I"
    })*/
    public void return_I_when_1_is_passed(){

        RomanTPP romanTPP = new RomanTPP();

        Assert.assertEquals("I", romanTPP.convert(1));
    }
}

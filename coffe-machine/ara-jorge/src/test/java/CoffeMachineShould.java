import org.junit.Assert;
import org.junit.Test;

public class CoffeMachineShould {
    @Test
    public void charge_1_for_a_black_coffe() {
        Coffe coffe = new BlackCoffe();
        Price expected = new Price(1);

        Assert.assertEquals(expected, coffe.getPrice());
    }
}
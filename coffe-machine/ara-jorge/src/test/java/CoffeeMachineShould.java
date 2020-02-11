import org.junit.Assert;
import org.junit.Test;

public class CoffeeMachineShould {
    @Test
    public void charge_1_for_a_black_coffee() {

        Coffe coffee = new BlackCoffee();
        Price expected = new Price(1);

        Assert.assertEquals(expected, coffee.getPrice());
    }

    @Test
    public void ensure_name_of_black_coffee_is_coffee() {

        Coffe coffee = new BlackCoffee();
        String expected = "Coffee";

        Assert.assertEquals(expected, coffee.getName());
    }
}
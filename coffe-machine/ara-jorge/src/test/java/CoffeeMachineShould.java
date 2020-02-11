import org.junit.Assert;
import org.junit.Test;

public class CoffeeMachineShould {
    @Test
    public void charge_1_for_a_black_coffee() {

        Coffee coffee = new BlackCoffee();
        Price expected = new Price(1.0);

        Assert.assertEquals(expected, coffee.getPrice());
    }

    @Test
    public void ensure_name_of_black_coffee_is_coffee() {

        Coffee coffee = new BlackCoffee();
        String expected = "Coffee";

        Assert.assertEquals(expected, coffee.getName());
    }

    @Test
    public void charge_13_for_a_milk_coffee(){

        Coffee milkCoffee = new Milk(new BlackCoffee());
        Price expected = new Price(1.3);

        Assert.assertEquals(expected, milkCoffee.getPrice());
    }

    @Test
    public void milk_coffee_name_is_milk_coffee() {

        Coffee milkCoffee = new Milk(new BlackCoffee());
        String expected = "Milk Coffee";

        Assert.assertEquals(expected, milkCoffee.getName());
    }
}
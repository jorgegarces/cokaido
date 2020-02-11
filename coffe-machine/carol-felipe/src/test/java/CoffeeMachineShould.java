import org.junit.Assert;
import org.junit.Test;

public class CoffeeMachineShould {
    @Test
    public void display_Coffee_as_name_1_euro_as_price(){
        Coffee coffee = new BlackCoffee();

        Assert.assertEquals("Coffee", coffee.name());
        Assert.assertEquals(1.00, coffee.price(),2);
    }

    @Test
    public void display_Milk_Coffee_as_name_1_30_euro_as_price(){
        Coffee milkCoffee = new Milk(new BlackCoffee());

        Assert.assertEquals("Milk Coffee", milkCoffee.name());
        Assert.assertEquals(1.30, milkCoffee.price(),2);
    }
}

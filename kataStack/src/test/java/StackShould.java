import org.junit.Assert;
import org.junit.Test;

public class StackShould {
    @Test(expected = NullPointerException.class)
    public void raiseAnErrorWhenAnEmptyStack() {
        Curray curray = new Curray();
        curray.pop();
    }

    @Test
    public void returnLastItemPushedToStack() {
        Curray<String> curray = new Curray<String>();

        curray.push("Pepito");

        Assert.assertEquals(curray.pop(), "Pepito");
    }

    @Test
    public void returnLastItemPushedToArrayStack() {
        Curray<String> curray = new Curray<String>();

        curray.push("Pepito");
        curray.push("Jose");

        Assert.assertEquals(curray.pop(),"Jose");
        Assert.assertEquals(curray.pop(), "Pepito");
    }

    @Test
    public void test() {
        Curray<Integer> curray = new Curray<Integer>();
        Assert.assertEquals(curray.push(1), 1);
    }
}

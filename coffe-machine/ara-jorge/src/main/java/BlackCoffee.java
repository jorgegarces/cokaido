public class BlackCoffee extends Coffe {

    public BlackCoffee(){
        name = "Coffee";
        price = new Price(1);
    }

    @Override
    public Price getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }
}

public class Milk extends Extra {
    Price price;
    String name;

    public Milk(Coffee coffee) {
        super(coffee);
        price = coffee.getPrice();
        name = coffee.getName();
    }

    @Override
    public Price getPrice() {
        price.add(0.3);
        return price;
    }

    @Override
    public String getName() {
        return "Milk " + name;
    }
}

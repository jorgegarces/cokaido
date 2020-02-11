public class Milk extends IngredientsDecorator {
    Coffee coffee;

    public Milk(Coffee coffee) {
        this.coffee = coffee;
    }

    public double price(){
        return 0.30 + coffee.price();
    }

    public String name(){
        return "Milk " + coffee.name();
    }
}

// Coffee blackCoffee = new BlackCoffee();
//Coffee milkCoffee = new Milk(blackCoffee);

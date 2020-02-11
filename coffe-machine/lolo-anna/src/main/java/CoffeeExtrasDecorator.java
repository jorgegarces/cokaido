public abstract class CoffeeExtrasDecorator implements Coffee {

    protected Coffee currentCoffee;

    public CoffeeExtrasDecorator(Coffee newCoffee) {
        this.currentCoffee = newCoffee;
    }

    public String getDescription() {
        return this.currentCoffee.getDescription();
    }

    public double getCost() {
        return this.currentCoffee.getCost();
    }
}


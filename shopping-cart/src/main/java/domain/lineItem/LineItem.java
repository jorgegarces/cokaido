package domain.lineItem;

import domain.product.Product;

import java.util.Objects;

public class LineItem {
    private final Product product;
    private int quantity;

    public LineItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineItem lineItem = (LineItem) o;
        return quantity == lineItem.quantity &&
                Objects.equals(product, lineItem.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, quantity);
    }

    public void doUpdateQuantity(int quantity) {
        this.quantity += quantity;
    }

    public boolean checkProduct(Product product) {
        return this.product.equals(product);
    }
}

package domain.product;

import java.util.Objects;

public class Product {
    private final ProductId productId;
    private final String name;
    private final double price;

    public Product(ProductId productId, String name, double price) {

        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 &&
                Objects.equals(productId, product.productId) &&
                Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, name, price);
    }
}

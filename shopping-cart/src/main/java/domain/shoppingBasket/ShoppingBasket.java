package domain.shoppingBasket;

import domain.product.ProductId;
import domain.user.UserId;

import java.util.Objects;

public class ShoppingBasket {

    private final UserId userId;
    private final String date;

    public ShoppingBasket(UserId userId, String date) {
        this.userId = userId;
        this.date = date;
    }

    public void add(ProductId productId, int quantity) {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingBasket that = (ShoppingBasket) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, date);
    }
}

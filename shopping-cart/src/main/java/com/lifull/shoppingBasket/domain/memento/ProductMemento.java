package com.lifull.shoppingBasket.domain.memento;

import java.util.Objects;

public class ProductMemento {
    public String name;
    public double price;
    public int id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductMemento that = (ProductMemento) o;
        return Double.compare(that.price, price) == 0 &&
                id == that.id &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, id);
    }
}

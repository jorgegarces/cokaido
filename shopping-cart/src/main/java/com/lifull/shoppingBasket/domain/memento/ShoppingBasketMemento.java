package com.lifull.shoppingBasket.domain.memento;

import java.util.Objects;


public class ShoppingBasketMemento {

    public String date;
    public LineItemListMemento lineItemList;
    public UserIdMemento userId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingBasketMemento memento = (ShoppingBasketMemento) o;
        return Objects.equals(date, memento.date) &&
                Objects.equals(lineItemList, memento.lineItemList) &&
                Objects.equals(userId, memento.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, lineItemList, userId);
    }

    @Override
    public String toString() {
        StringBuilder basketSummary = new StringBuilder();
        basketSummary.append("Creation date : ").append(this.date).append("\n");

        for (LineItemMemento lineItem : lineItemList.items) {

            String formatterLineItem = String.format("%sx %s %sx %.2f = €%.2f\n",
                    lineItem.quantity,
                    lineItem.productMemento.name,
                    lineItem.quantity,
                    lineItem.productMemento.price,
                    lineItem.total);
            basketSummary.append(formatterLineItem);
        }

        basketSummary.append(String.format("Total: €%.2f ", lineItemList.total));
        return basketSummary.toString();
    }
}

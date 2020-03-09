package domain.memento;

import java.util.Objects;


public class ShoppingBasketMemento {

    public String date;
    public LineItemListMemento lineItemList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingBasketMemento that = (ShoppingBasketMemento) o;
        return Objects.equals(date, that.date) &&
                Objects.equals(lineItemList, that.lineItemList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, lineItemList);
    }

    @Override
    public String toString() {
        StringBuilder basketSummary = new StringBuilder();
        basketSummary.append("Creation date : " + this.date + "\n");

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

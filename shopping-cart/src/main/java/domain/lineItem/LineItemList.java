package domain.lineItem;

import domain.product.Product;

import java.util.ArrayList;
import java.util.Objects;

public class LineItemList {

    private final ArrayList<LineItem> itemList;

    public LineItemList() {
        this.itemList = new ArrayList<>();
    }

    public void add(Product product, int quantity) {
        LineItem lineItem = productExists(product);

        if (lineItem != null) lineItem.doUpdateQuantity(quantity);

        else itemList.add(new LineItem(product, quantity));
    }

    private LineItem productExists(Product product) {
        for (LineItem lineItem : itemList) {
            if (lineItem.checkProduct(product)) return lineItem;
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineItemList that = (LineItemList) o;
        return Objects.equals(itemList, that.itemList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemList);
    }
}

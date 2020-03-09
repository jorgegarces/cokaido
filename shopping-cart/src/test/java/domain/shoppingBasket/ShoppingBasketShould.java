package domain.shoppingBasket;

import domain.product.ProductId;
import domain.user.UserId;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import domain.product.Product;

class ShoppingBasketShould {

    @Test
    void increase_basket_products_quantity() {

        ProductId productId = new ProductId(10002);
        Product product = new Product(productId, "The Hobbit",5.00);
        ShoppingBasket shoppingBasket = new ShoppingBasket(new UserId(1),"04/03/2020");
        ShoppingBasket expectedShoppingBasket = new ShoppingBasket(new UserId(1),"04/03/2020");
        expectedShoppingBasket.add(product,2);

        shoppingBasket.add(product, 1);
        shoppingBasket.add(product, 1);

        Assert.assertEquals(expectedShoppingBasket, shoppingBasket);
    }
}
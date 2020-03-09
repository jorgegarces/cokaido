package domain.shoppingBasket;

import domain.exceptions.NegativeQuantityException;
import domain.product.ProductId;
import domain.user.UserId;
import org.junit.Assert;
import domain.product.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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

    @Test
    public void not_allow_add_negative_quantity(){
        ProductId productId = new ProductId(10002);
        Product product = new Product(productId, "The Hobbit",5.00);
        ShoppingBasket shoppingBasket = new ShoppingBasket(new UserId(1),"04/03/2020");

        Assertions.assertThrows(NegativeQuantityException.class, ()-> shoppingBasket.add(product, -1));
    }
}
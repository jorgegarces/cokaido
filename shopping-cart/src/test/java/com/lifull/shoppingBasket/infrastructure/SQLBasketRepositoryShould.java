package com.lifull.shoppingBasket.infrastructure;

import com.lifull.shoppingBasket.domain.product.Product;
import com.lifull.shoppingBasket.domain.product.ProductId;
import com.lifull.shoppingBasket.domain.shoppingBasket.ShoppingBasket;
import com.lifull.shoppingBasket.domain.user.UserId;
import com.lifull.shoppingBasket.infrastructure.sql.SQLBasketRepository;
import com.lifull.shoppingBasket.infrastructure.sql.SQLProductRepository;
import com.lifull.shoppingBasket.services.TimeServer;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SQLBasketRepositoryShould {

    @Autowired
    private SQLBasketRepository basketRepository;

    @Test
    public void save_and_retrieve_shopping_basket_from_repository_correctly() {
        ShoppingBasket shoppingBasket = new ShoppingBasket(new UserId(1), "16/03/2020");
        ProductId productId = new ProductId(10002);
        Product product = new Product(productId, "The Hobbit",5.00);
        shoppingBasket.add(product, 1);
        basketRepository.save(shoppingBasket);

        Assert.assertEquals(shoppingBasket, basketRepository.get(new UserId(1)));
    }

}

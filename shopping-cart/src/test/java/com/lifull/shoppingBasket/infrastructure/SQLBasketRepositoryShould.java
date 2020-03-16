package com.lifull.shoppingBasket.infrastructure;

import com.lifull.shoppingBasket.domain.shoppingBasket.ShoppingBasket;
import com.lifull.shoppingBasket.domain.user.UserId;
import com.lifull.shoppingBasket.infrastructure.sql.SQLBasketRepository;
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
        basketRepository.save(shoppingBasket);

        Assert.assertEquals(shoppingBasket, basketRepository.get(new UserId(1)));
    }

}

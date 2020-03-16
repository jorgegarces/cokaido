package com.lifull.shoppingBasket.infrastructure;

import com.lifull.shoppingBasket.domain.shoppingBasket.ShoppingBasket;
import com.lifull.shoppingBasket.domain.user.UserId;
import com.lifull.shoppingBasket.infrastructure.inMemory.InMemoryBasketRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class InMemoryBasketRepositoryShould {
    @Test
    public void save_and_retrieve_a_shopping_basket_correctly(){

        ShoppingBasket shoppingBasket = new ShoppingBasket(new UserId(1), "04/03/2020");
        InMemoryBasketRepository inMemoryBasketRepository = new InMemoryBasketRepository();
        inMemoryBasketRepository.save(shoppingBasket);

        Assert.assertEquals(shoppingBasket, inMemoryBasketRepository.get(new UserId(1)));
    }
}
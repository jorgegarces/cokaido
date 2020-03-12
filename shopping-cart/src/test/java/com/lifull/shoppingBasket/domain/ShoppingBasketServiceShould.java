package com.lifull.shoppingBasket.domain;

import com.lifull.shoppingBasket.infrastructure.IBasketRepository;
import com.lifull.shoppingBasket.infrastructure.IProductRepository;
import com.lifull.shoppingBasket.domain.product.ProductId;
import com.lifull.shoppingBasket.domain.shoppingBasket.ShoppingBasket;
import com.lifull.shoppingBasket.services.ITimeServer;
import com.lifull.shoppingBasket.domain.user.UserId;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.lifull.shoppingBasket.domain.product.Product;

import static org.mockito.Mockito.*;

public class ShoppingBasketServiceShould {
    @Mock IProductRepository productRepository;
    @Mock IBasketRepository basketRepository;
    @Mock ITimeServer timeServer;

    @Test
        public void send_new_shopping_basket_to_repo_when_basket_does_not_exist() {

        MockitoAnnotations.initMocks(this);
        UserId userId = new UserId(1);
        ProductId productId = new ProductId(10002);
        Product product = new Product(productId, "The Hobbit",5.00);
        ShoppingBasketService shoppingBasketService = new ShoppingBasketService(productRepository, basketRepository, timeServer);
        when(timeServer.getDate()).thenReturn("10/02/1990");
        ShoppingBasket shoppingBasket = new ShoppingBasket(userId, timeServer.getDate());
        when(basketRepository.get(userId)).thenReturn(null);
        when(productRepository.get(productId)).thenReturn(java.util.Optional.of(product));
        shoppingBasket.add(product,2);

        shoppingBasketService.addItem(userId, productId, 2);

        verify(basketRepository).save(shoppingBasket);
    }
}
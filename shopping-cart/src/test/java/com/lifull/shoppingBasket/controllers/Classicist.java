package com.lifull.shoppingBasket.controllers;

import com.lifull.shoppingBasket.domain.ShoppingBasketService;
import com.lifull.shoppingBasket.domain.memento.ShoppingBasketMemento;
import com.lifull.shoppingBasket.domain.product.Product;
import com.lifull.shoppingBasket.domain.product.ProductId;
import com.lifull.shoppingBasket.domain.shoppingBasket.ShoppingBasket;
import com.lifull.shoppingBasket.domain.user.UserId;
import com.lifull.shoppingBasket.infrastructure.InMemoryBasketRepository;
import com.lifull.shoppingBasket.infrastructure.InMemoryProductRepository;
import com.lifull.shoppingBasket.services.ITimeServer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class Classicist {
    @Mock
    InMemoryBasketRepository basketRepository;
    @Mock
    InMemoryProductRepository productRepository;
    @Mock
    ITimeServer timeServer;
    @InjectMocks
    private ShoppingBasketController controller;

    @Test
    public void retrieve_basket_from_userId() {
        MockitoAnnotations.initMocks(this);
        when(basketRepository.memento(new UserId(1))).thenReturn(new ShoppingBasketMemento());

        ResponseEntity<ShoppingBasketMemento> basket = controller.shoppingBasketByUserId(1);

        Assert.assertNotNull(basket);
        Assert.assertEquals(HttpStatus.OK,basket.getStatusCode());
    }
}

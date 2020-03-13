package com.lifull.shoppingBasket.controllers;

import com.lifull.shoppingBasket.domain.memento.ShoppingBasketMemento;
import com.lifull.shoppingBasket.domain.product.Product;
import com.lifull.shoppingBasket.domain.product.ProductId;
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

import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ShoppingBasketControllerShould {
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
        Assert.assertEquals(HttpStatus.OK, basket.getStatusCode());
    }

    @Test
    public void create_basket() {

        MockitoAnnotations.initMocks(this);
        when(productRepository.get(new ProductId(20))).thenReturn(java.util.Optional.of(new Product(new ProductId(20), "name", 1.00)));
        AddItemUseCase addItemUseCase = new AddItemUseCase();
        addItemUseCase.userId = 1;
        addItemUseCase.productId = 20;
        addItemUseCase.quantity = 1;

        ResponseEntity<Object> responseExpected = controller.addItem(addItemUseCase);

        Assert.assertEquals(HttpStatus.CREATED, responseExpected.getStatusCode());
        Assert.assertEquals("Product added correctly", responseExpected.getBody());
    }

    @Test
    public void throw_an_error_if_product_id_does_not_exist() {

        MockitoAnnotations.initMocks(this);
        when(productRepository.get(new ProductId(2))).thenReturn(Optional.empty());

        ResponseEntity<Object> response = controller.addItem(new AddItemUseCase());

        Assert.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        Assert.assertEquals("product does not exist", response.getBody());
    }

    @Test
    public void throw_an_error_if_product_quantity_is_negative() {

        MockitoAnnotations.initMocks(this);
        when(productRepository.get(new ProductId(20))).thenReturn(java.util.Optional.of(new Product(new ProductId(20), "name", 1.00)));
        AddItemUseCase addItemUseCase = new AddItemUseCase();
        addItemUseCase.productId = 20;
        addItemUseCase.quantity = -1;

        ResponseEntity<Object> response = controller.addItem(addItemUseCase);

        Assert.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        Assert.assertEquals("quantity cannot be negative", response.getBody());
    }
}

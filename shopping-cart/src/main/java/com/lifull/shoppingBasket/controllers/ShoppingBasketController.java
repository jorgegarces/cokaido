package com.lifull.shoppingBasket.controllers;

import com.lifull.shoppingBasket.domain.ShoppingBasketService;
import com.lifull.shoppingBasket.domain.exceptions.ShoppingBasketException;
import com.lifull.shoppingBasket.domain.memento.ShoppingBasketMemento;
import com.lifull.shoppingBasket.domain.product.ProductId;
import com.lifull.shoppingBasket.services.ITimeServer;
import com.lifull.shoppingBasket.domain.user.UserId;
import com.lifull.shoppingBasket.infrastructure.IBasketRepository;
import com.lifull.shoppingBasket.infrastructure.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShoppingBasketController {

    @Autowired
    IBasketRepository sqlBasketRepository;
    @Autowired
    IProductRepository sqlProductRepository;
    @Autowired
    ITimeServer timeServer;

    @GetMapping("/shoppingBaskets")
    public ResponseEntity<ShoppingBasketMemento> shoppingBasketByUserId(@RequestParam int userId) {
        ShoppingBasketService shoppingBasketService = new ShoppingBasketService(sqlProductRepository, sqlBasketRepository, timeServer);
        return new ResponseEntity<>(shoppingBasketService.basketFor(new UserId(userId)),HttpStatus.OK);
    }

    @PostMapping(value = "/shoppingBaskets", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addItem(@RequestBody AddItemUseCase addItemUseCase) {
        ShoppingBasketService shoppingBasketService = new ShoppingBasketService(sqlProductRepository, sqlBasketRepository, timeServer);
        try {
            shoppingBasketService.addItem(
                    new UserId(addItemUseCase.userId),
                    new ProductId(addItemUseCase.productId),
                    addItemUseCase.quantity);
            return new ResponseEntity<>("Product added correctly", HttpStatus.CREATED);
        } catch (ShoppingBasketException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
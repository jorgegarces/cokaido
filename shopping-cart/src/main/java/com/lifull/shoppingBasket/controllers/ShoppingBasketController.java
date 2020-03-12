package com.lifull.shoppingBasket.controllers;

import com.lifull.shoppingBasket.domain.ShoppingBasketService;
import com.lifull.shoppingBasket.domain.exceptions.ProductDoesNotExistException;
import com.lifull.shoppingBasket.domain.product.ProductId;
import com.lifull.shoppingBasket.services.ITimeServer;
import com.lifull.shoppingBasket.domain.user.UserId;
import com.lifull.shoppingBasket.infrastructure.IBasketRepository;
import com.lifull.shoppingBasket.infrastructure.IProductRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShoppingBasketController {

    @Autowired
    IBasketRepository inMemoryBasketRepository;
    @Autowired
    IProductRepository inMemoryProductRepository;
    @Autowired
    ITimeServer timeServer;

    /*@GetMapping("/shoppingBaskets/{id}")
    public ShoppingBasketMemento shoppingBasketByUserId(@PathVariable int id) {
        return basketRepository.findById(id);
    }

    @GetMapping("/shoppingBaskets")
    public List<ShoppingBasketMemento> allShoppingBaskets() {
        return basketRepository.findAll();
    }*/

    @PostMapping(value = "/shoppingBaskets", consumes = "application/json", produces = "application/json")
    public ResponseEntity addItem(@RequestBody AddItemUseCase addItemUseCase) {
        ShoppingBasketService shoppingBasketService = new ShoppingBasketService(inMemoryProductRepository, inMemoryBasketRepository, timeServer);
        try {
            shoppingBasketService.addItem(
                    new UserId(addItemUseCase.userId),
                    new ProductId(addItemUseCase.productId),
                    addItemUseCase.quantity);
            return new ResponseEntity<>("Product added correctly", HttpStatus.CREATED);
        } catch(ProductDoesNotExistException e) {
            ResponseEntity errorResponse = new ResponseEntity(e.message, HttpStatus.BAD_REQUEST);
            return errorResponse;
        }
    }
}
package com.lifull.shoppingBasket.domain.exceptions;

public class ProductDoesNotExistException extends ShoppingBasketException{

    public ProductDoesNotExistException() {
        this.message = "product does not exist";
    }
}

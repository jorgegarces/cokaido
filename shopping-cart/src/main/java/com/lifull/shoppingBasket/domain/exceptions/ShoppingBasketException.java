package com.lifull.shoppingBasket.domain.exceptions;

public class ShoppingBasketException extends RuntimeException {
    protected String message = "";

    public String getMessage() {
        return message;
    }
}

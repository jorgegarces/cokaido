package com.lifull.shoppingBasket.domain.exceptions;


public class NegativeQuantityException extends ShoppingBasketException {

    public NegativeQuantityException() {
        this.message = "quantity cannot be negative";
    }
}


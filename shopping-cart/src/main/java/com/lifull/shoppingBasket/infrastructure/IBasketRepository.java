package com.lifull.shoppingBasket.infrastructure;

import com.lifull.shoppingBasket.domain.memento.ShoppingBasketMemento;
import com.lifull.shoppingBasket.domain.shoppingBasket.ShoppingBasket;
import com.lifull.shoppingBasket.domain.user.UserId;

public interface IBasketRepository {

    public void save(ShoppingBasket shoppingBasket);

    ShoppingBasket get(UserId userId);

    ShoppingBasketMemento memento(UserId userId);
}


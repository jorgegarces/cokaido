package com.lifull.shoppingBasket.infrastructure.inMemory;

import com.lifull.shoppingBasket.domain.memento.ShoppingBasketMemento;
import com.lifull.shoppingBasket.domain.shoppingBasket.ShoppingBasket;
import com.lifull.shoppingBasket.domain.user.UserId;
import com.lifull.shoppingBasket.infrastructure.IBasketRepository;
import org.springframework.stereotype.Component;

import java.util.HashMap;
@Component
public class InMemoryBasketRepository implements IBasketRepository {

    HashMap<UserId, ShoppingBasket> userBasketList = new HashMap<UserId, ShoppingBasket>();

    @Override
    public void save(ShoppingBasket shoppingBasket) {
        ShoppingBasketMemento shoppingBasketMemento = shoppingBasket.createMemento();
        userBasketList.put(new UserId(shoppingBasketMemento.userId.id), shoppingBasket);
    }

    @Override
    public ShoppingBasket get(UserId userId) {
        if(userBasketList.containsKey(userId)) return userBasketList.get(userId);
        return null;
    }

    @Override
    public ShoppingBasketMemento memento(UserId userId) {
        ShoppingBasket shoppingBasket = get(userId);
        if(shoppingBasket == null) return null;
        return shoppingBasket.createMemento();
    }
}

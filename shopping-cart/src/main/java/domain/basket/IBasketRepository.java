package domain.basket;

import domain.shoppingBasket.ShoppingBasket;
import domain.user.UserId;

public interface IBasketRepository {

    public void save(ShoppingBasket shoppingBasket);

    ShoppingBasket get(UserId userId);
}

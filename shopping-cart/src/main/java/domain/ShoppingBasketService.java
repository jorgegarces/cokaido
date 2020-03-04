package domain;

import domain.basket.IBasketRepository;
import domain.product.IProductRepository;
import domain.product.ProductId;
import domain.shoppingBasket.ShoppingBasket;
import domain.user.UserId;
import domain.timeserver.ITimeServer;

public class ShoppingBasketService {
    public ShoppingBasketService(IProductRepository inMemoryProductRepository, IBasketRepository inMemoryBasketRepository, ITimeServer timeServer) {
    }

    public void addItem(UserId userId, ProductId productId, int quantity) {
    }

    public ShoppingBasket basketFor(UserId userId) {
        return null;
    }
}

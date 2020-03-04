package domain;

import domain.basket.IBasketRepository;
import domain.product.IProductRepository;
import domain.product.ProductId;
import domain.shoppingBasket.ShoppingBasket;
import domain.user.UserId;
import domain.timeserver.ITimeServer;

public class ShoppingBasketService {
    private final IProductRepository inMemoryProductRepository;
    private final IBasketRepository inMemoryBasketRepository;
    private final ITimeServer timeServer;

    public ShoppingBasketService(IProductRepository inMemoryProductRepository, IBasketRepository inMemoryBasketRepository, ITimeServer timeServer) {
        this.inMemoryProductRepository = inMemoryProductRepository;
        this.inMemoryBasketRepository = inMemoryBasketRepository;
        this.timeServer = timeServer;
    }

    public void addItem(UserId userId, ProductId productId, int quantity) {

        ShoppingBasket shoppingBasket = inMemoryBasketRepository.get(userId);
        if (shoppingBasket == null) shoppingBasket = new ShoppingBasket(userId, timeServer.getDate());

        shoppingBasket.add(productId, quantity);

        inMemoryBasketRepository.save(shoppingBasket);
    }

    public ShoppingBasket basketFor(UserId userId) {
        return null;
    }
}

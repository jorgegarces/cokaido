package com.lifull.shoppingBasket.domain;

import com.lifull.shoppingBasket.infrastructure.IBasketRepository;
import com.lifull.shoppingBasket.domain.memento.ShoppingBasketMemento;
import com.lifull.shoppingBasket.infrastructure.IProductRepository;
import com.lifull.shoppingBasket.domain.product.ProductId;
import com.lifull.shoppingBasket.domain.shoppingBasket.ShoppingBasket;
import com.lifull.shoppingBasket.domain.user.UserId;
import com.lifull.shoppingBasket.services.ITimeServer;
import com.lifull.shoppingBasket.domain.product.Product;

public class ShoppingBasketService {
    private final IProductRepository productRepository;
    private final IBasketRepository basketRepository;
    private final ITimeServer timeServer;

    public ShoppingBasketService(IProductRepository productRepository, IBasketRepository basketRepository, ITimeServer timeServer) {
        this.productRepository = productRepository;
        this.basketRepository = basketRepository;
        this.timeServer = timeServer;
    }

    public void addItem(UserId userId, ProductId productId, int quantity) {
        ShoppingBasket shoppingBasket = basketRepository.get(userId);
        if (shoppingBasket == null) shoppingBasket = new ShoppingBasket(userId, timeServer.getDate());

        Product product = productRepository.get(productId).orElse(null);
        shoppingBasket.add(product, quantity);
        basketRepository.save(shoppingBasket);
    }

    public ShoppingBasketMemento basketFor(UserId userId) {

        return basketRepository.memento(userId);
    }

    @Override
    public String toString() {
        return "ShoppingBasketService{" +
                "productRepository=" + productRepository +
                ", basketRepository=" + basketRepository +
                ", timeServer=" + timeServer +
                '}';
    }
}

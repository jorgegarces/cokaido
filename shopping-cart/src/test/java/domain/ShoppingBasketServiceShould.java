package domain;

import domain.basket.IBasketRepository;
import domain.product.IProductRepository;
import domain.product.ProductId;
import domain.shoppingBasket.ShoppingBasket;
import domain.timeserver.ITimeServer;
import domain.user.UserId;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

public class ShoppingBasketServiceShould {
    @Mock IProductRepository inMemoryProductRepository;
    @Mock IBasketRepository inMemoryBasketRepository;
    @Mock ITimeServer timeServer;

    @Test
        public void send_new_shopping_basket_to_repo_when_basket_does_not_exist() {
        MockitoAnnotations.initMocks(this);
        UserId userId = new UserId(1);
        ProductId productId = new ProductId(10002);
        ShoppingBasketService shoppingBasketService = new ShoppingBasketService(inMemoryProductRepository, inMemoryBasketRepository, timeServer);
        when(inMemoryBasketRepository.get(userId)).thenReturn(null);

        shoppingBasketService.addItem(userId, productId, 2);

        verify(inMemoryBasketRepository).save(new ShoppingBasket(userId, timeServer.getDate()));

    }
}


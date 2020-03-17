package com.lifull.shoppingBasket.infrastructure;

import com.lifull.shoppingBasket.domain.product.Product;
import com.lifull.shoppingBasket.domain.product.ProductId;
import com.lifull.shoppingBasket.infrastructure.sql.SQLProductRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;

import java.util.Optional;

@SpringBootTest
public class SQLProductRepositoryShould {

    @Autowired
    private SQLProductRepository productRepository;

    @Test
    public void serve_a_requested_product_from_its_id() {
        MockitoAnnotations.initMocks(this);
        Product expected = new Product(new ProductId(20001), "Game of Thrones", 9.00);

        Assert.assertEquals(Optional.of(expected), productRepository.get(new ProductId(20001)));
    }
}

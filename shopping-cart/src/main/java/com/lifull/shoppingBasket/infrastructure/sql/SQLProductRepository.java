package com.lifull.shoppingBasket.infrastructure.sql;

import com.lifull.shoppingBasket.domain.product.Product;
import com.lifull.shoppingBasket.domain.product.ProductId;
import com.lifull.shoppingBasket.infrastructure.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Primary
public class SQLProductRepository implements IProductRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Optional<Product> get(ProductId productId) {
        return jdbcTemplate.queryForObject("SELECT * FROM products WHERE id = ?",
                new Object[]{productId.getProductId()}, (rs, rowNum) ->
                        Optional.of(new Product(new ProductId(rs.getInt("id")), rs.getString("name"), rs.getDouble("price"))));
    }
}

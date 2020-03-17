package com.lifull.shoppingBasket.infrastructure.sql;

import com.lifull.shoppingBasket.domain.memento.*;
import com.lifull.shoppingBasket.domain.product.Product;
import com.lifull.shoppingBasket.domain.product.ProductId;
import com.lifull.shoppingBasket.domain.shoppingBasket.ShoppingBasket;
import com.lifull.shoppingBasket.domain.user.UserId;
import com.lifull.shoppingBasket.infrastructure.IBasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@Primary
public class SQLBasketRepository implements IBasketRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void save(ShoppingBasket shoppingBasket) {
        ShoppingBasketMemento shoppingBasketMemento = shoppingBasket.createMemento();

        jdbcTemplate.update("INSERT INTO baskets (userId, date) VALUES (?, ?)", shoppingBasketMemento.userId.id, shoppingBasketMemento.date);
        for (LineItemMemento lineItemMemento : shoppingBasketMemento.lineItemList.items) {
            jdbcTemplate.update("INSERT INTO line_items (userId, productId, quantity) VALUES (?, ?, ?)", shoppingBasketMemento.userId.id, lineItemMemento.productMemento.id, lineItemMemento.quantity);
        }
    }

    @Override
    public ShoppingBasket get(UserId userId) {
        UserIdMemento userIdMemento = userId.createMemento();
        ShoppingBasketMemento shoppingBasketMemento = new ShoppingBasketMemento();
        ProductMemento productMemento = new ProductMemento();
        LineItemMemento lineItemMemento = new LineItemMemento();
        LineItemListMemento lineItemListMemento = new LineItemListMemento();
        shoppingBasketMemento.lineItemList = lineItemListMemento;
        try {
            jdbcTemplate.queryForObject("SELECT * FROM baskets WHERE userId=?",
                    new Object[]{userIdMemento.id}, (rs, rowNum) -> {
                        shoppingBasketMemento.userId = userIdMemento;
                        shoppingBasketMemento.date = rs.getString("date");
                        return null;
                    });
        } catch(EmptyResultDataAccessException e) {
           return null;
        }

        jdbcTemplate.queryForObject("SELECT li.productId, li.quantity, p.name, p.price FROM line_items li INNER JOIN products p ON li.productId = p.id WHERE li.userId=?",
            new Object[]{userIdMemento.id}, (rs, rowNum) -> {
                        productMemento.id = rs.getInt("productId");
                        productMemento.name = rs.getString("name");
                        productMemento.price = rs.getDouble("price");
                        lineItemMemento.productMemento = productMemento;
                        lineItemMemento.quantity = rs.getInt("quantity");
                        shoppingBasketMemento.lineItemList.items.add(lineItemMemento);
                    return null;
                });

        return ShoppingBasket.createFromMemento(shoppingBasketMemento);
    }

    @Override
    public ShoppingBasketMemento memento(UserId userId) {
        return this.get(userId).createMemento();
    }
}

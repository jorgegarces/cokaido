package com.lifull.shoppingBasket.infrastructure.sql;

import com.lifull.shoppingBasket.domain.memento.LineItemMemento;
import com.lifull.shoppingBasket.domain.memento.ShoppingBasketMemento;
import com.lifull.shoppingBasket.domain.memento.UserIdMemento;
import com.lifull.shoppingBasket.domain.product.Product;
import com.lifull.shoppingBasket.domain.product.ProductId;
import com.lifull.shoppingBasket.domain.shoppingBasket.ShoppingBasket;
import com.lifull.shoppingBasket.domain.user.UserId;
import com.lifull.shoppingBasket.infrastructure.IBasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Optional;
import java.util.UUID;

public class SQLBasketRepository implements IBasketRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void save(ShoppingBasket shoppingBasket) {
        ShoppingBasketMemento shoppingBasketMemento = shoppingBasket.createMemento();

        jdbcTemplate.update("INSERT INTO baskets (userId, date) VALUES (?, ?)", shoppingBasketMemento.userId, shoppingBasketMemento.date);
        for (LineItemMemento lineItemMemento : shoppingBasketMemento.lineItemList.items) {
            jdbcTemplate.update("INSERT INTO line_items (userId, productId, quantity) VALUES (?, ?, ?)", shoppingBasketMemento.userId.id,lineItemMemento.productMemento.id, lineItemMemento.quantity);
        }
    }

    @Override
    public ShoppingBasket get(UserId userId) {
        UserIdMemento userIdMemento = userId.createMemento();
        return jdbcTemplate.queryForObject("SELECT * FROM baskets WHERE userId = ?",
                new Object[]{userIdMemento.id}, (rs, rowNum) ->
                        new ShoppingBasket(new UserId(rs.getInt("userId")), rs.getString("date")));

    }

    @Override
    public ShoppingBasketMemento memento(UserId userId) {
        return null;
    }
}

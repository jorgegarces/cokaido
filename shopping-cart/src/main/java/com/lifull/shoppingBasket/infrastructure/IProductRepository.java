package com.lifull.shoppingBasket.infrastructure;

import com.lifull.shoppingBasket.domain.product.Product;
import com.lifull.shoppingBasket.domain.product.ProductId;

import java.util.Optional;

public interface IProductRepository {

    Optional<Product> get(ProductId productId);
}

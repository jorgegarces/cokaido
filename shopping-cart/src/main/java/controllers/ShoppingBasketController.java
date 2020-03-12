package controllers;

import domain.ShoppingBasketService;
import domain.product.ProductId;
import services.ITimeServer;
import domain.user.UserId;
import infrastructure.IBasketRepository;
import infrastructure.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShoppingBasketController {

    @Autowired
    IBasketRepository inMemoryBasketRepository;
    @Autowired
    IProductRepository inMemoryProductRepository;
    @Autowired
    ITimeServer timeServer;

    /*@GetMapping("/shoppingBaskets/{id}")
    public ShoppingBasketMemento shoppingBasketByUserId(@PathVariable int id) {
        return basketRepository.findById(id);
    }

    @GetMapping("/shoppingBaskets")
    public List<ShoppingBasketMemento> allShoppingBaskets() {
        return basketRepository.findAll();
    }*/

    @PostMapping(value = "/shoppingBaskets", consumes = "application/json", produces = "application/json")
    public void addItem(@RequestBody AddItemUseCase addItemUseCase) {
        ShoppingBasketService shoppingBasketService = new ShoppingBasketService(inMemoryProductRepository, inMemoryBasketRepository, timeServer);
        shoppingBasketService.addItem(
                new UserId(addItemUseCase.userId),
                new ProductId(addItemUseCase.productId),
                addItemUseCase.quantity);
    }
}
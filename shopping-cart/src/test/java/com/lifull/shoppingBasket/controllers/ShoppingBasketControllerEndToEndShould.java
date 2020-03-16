package com.lifull.shoppingBasket.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lifull.shoppingBasket.domain.ShoppingBasketService;
import com.lifull.shoppingBasket.domain.memento.*;
import com.lifull.shoppingBasket.domain.product.ProductId;
import com.lifull.shoppingBasket.domain.user.UserId;
import com.lifull.shoppingBasket.infrastructure.inMemory.InMemoryBasketRepository;
import com.lifull.shoppingBasket.infrastructure.inMemory.InMemoryProductRepository;
import com.lifull.shoppingBasket.services.ITimeServer;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@SpringBootTest
@AutoConfigureMockMvc
public class ShoppingBasketControllerEndToEndShould {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private InMemoryProductRepository productRepository;

    @Autowired
    private InMemoryBasketRepository basketRepository;

    @Autowired
    private ITimeServer timeServer;

    @Test
    public void add_new_item_to_basket_when_all_parameters_are_correct() throws Exception {
        AddItemUseCase addItemUseCase = new AddItemUseCase();
        addItemUseCase.productId = 20001;
        addItemUseCase.userId = 2;
        addItemUseCase.quantity = 1;
        String jsonRequest = new ObjectMapper().writeValueAsString(addItemUseCase);
        MvcResult result = this.mockMvc.perform(post("/shoppingBaskets").contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest)).andDo(print()).andExpect(status().isCreated())
                .andReturn();

        String message = result.getResponse().getContentAsString();

        Assert.assertEquals(message, "Product added correctly");
    }

    @Test
    public void throw_an_error_if_product_id_does_not_exist() throws Exception {
        AddItemUseCase addItemUseCase = new AddItemUseCase();
        addItemUseCase.productId = 20002;
        addItemUseCase.userId = 1;
        addItemUseCase.quantity = 1;
        String jsonRequest = new ObjectMapper().writeValueAsString(addItemUseCase);
        MvcResult result = this.mockMvc.perform(post("/shoppingBaskets").contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest)).andDo(print()).andExpect(status().isBadRequest())
                .andReturn();

        String message = result.getResponse().getContentAsString();

        Assert.assertEquals(message, "product does not exist");
    }

    @Test
    public void throw_an_error_if_quantity_is_negative() throws Exception {
        AddItemUseCase addItemUseCase = new AddItemUseCase();
        addItemUseCase.productId = 20001;
        addItemUseCase.userId = 1;
        addItemUseCase.quantity = -1;
        String jsonRequest = new ObjectMapper().writeValueAsString(addItemUseCase);
        MvcResult result = this.mockMvc.perform(post("/shoppingBaskets").contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest)).andDo(print()).andExpect(status().isBadRequest())
                .andReturn();

        String message = result.getResponse().getContentAsString();

        Assert.assertEquals(message, "quantity cannot be negative");
    }

    @Test
    public void retrieve_a_users_shopping_basket_memento() throws Exception {
        ShoppingBasketMemento expectedMemento = new ShoppingBasketMemento();
        expectedMemento.date = timeServer.getDate();
        ProductMemento productMemento = new ProductMemento();
        productMemento.name = "The Hobbit";
        productMemento.price = 5.00;
        LineItemMemento lineItemMemento = new LineItemMemento();
        lineItemMemento.productMemento = productMemento;
        lineItemMemento.quantity = 2;
        lineItemMemento.total = 10.00;
        expectedMemento.lineItemList = new LineItemListMemento();
        expectedMemento.lineItemList.items.add(lineItemMemento);
        expectedMemento.lineItemList.total = 10.00;
        UserIdMemento userIdMemento = new UserIdMemento();
        userIdMemento.id = 1;
        expectedMemento.userId = userIdMemento;

        ShoppingBasketService shoppingBasketService = new ShoppingBasketService(productRepository, basketRepository, timeServer);
        shoppingBasketService.addItem(new UserId(1), new ProductId(10002), 2);

        MvcResult result = this.mockMvc.perform(get("/shoppingBaskets?userId=1"))
                .andDo(print()).andExpect(status().isOk())
                .andReturn();

        String contentAsString = result.getResponse().getContentAsString();

        ShoppingBasketMemento memento = objectMapper.readValue(contentAsString, ShoppingBasketMemento.class);


        Assert.assertEquals(expectedMemento, memento);
    }
}


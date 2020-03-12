package com.lifull.shoppingBasket.controllers;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
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
public class ShoppingBasketControllerShould {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void add_new_item_to_basket_when_all_parameters_are_correct() throws Exception {
        AddItemUseCase addItemUseCase = new AddItemUseCase();
        addItemUseCase.productId = 20001;
        addItemUseCase.userId = 1;
        addItemUseCase.quantity = 1;
        String jsonRequest = new ObjectMapper().writeValueAsString(addItemUseCase);
        MvcResult result = this.mockMvc.perform(post("/shoppingBaskets").contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest)).andDo(print()).andExpect(status().isCreated())
                .andReturn();

        String message = result.getResponse().getContentAsString();

        Assert.assertEquals(message, "Product added correctly");
    }
}

/*package controllers;
import static org.junit.Assert.assertNotNull;
import com.lifull.shoppingBasket.RestServiceApplication;
import com.lifull.shoppingBasket.controllers.AddItemUseCase;
import com.lifull.shoppingBasket.controllers.ShoppingBasketController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
@SpringBootTest(classes = RestServiceApplication.class)
@AutoConfigureMockMvc
public class ShoppingBasketControllerShould {
    @Autowired
    private ShoppingBasketController shoppingBasketController;
    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        AddItemUseCase item = new AddItemUseCase();
        item.productId = 20001;
        item.userId = 1;
        item.quantity = 2;
        ResponseEntity response = shoppingBasketController.addItem(item);
        assertNotNull(response);
        System.out.println(response);
    }
}*/

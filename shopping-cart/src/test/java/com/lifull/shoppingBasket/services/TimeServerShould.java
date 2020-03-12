package com.lifull.shoppingBasket.services;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class TimeServerShould {
    @Test
    public void produce_a_string_with_todays_date() {
        ITimeServer timeServer = new TimeServer();

        Assert.assertEquals("12/03/2020", timeServer.getDate());
    }
}

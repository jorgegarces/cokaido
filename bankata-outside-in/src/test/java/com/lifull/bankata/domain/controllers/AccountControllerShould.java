package com.lifull.bankata.domain.controllers;

import com.lifull.bankata.controllers.AccountController;
import com.lifull.bankata.infrastructure.TransactionRepository;
import com.lifull.bankata.services.TimeServer;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AccountControllerShould {
    @Mock
    TransactionRepository transactionRepository;
    @Mock
    TimeServer timeServer;
    @InjectMocks
    AccountController accountController;

    @Test
    public void test() {

    }
}

package com.lifull.bankata.controllers;

import com.lifull.bankata.domain.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping(value = "/deposit", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> deposit(@RequestBody TransactionCase transactionCase) {
        try {
            accountService.deposit(transactionCase.amount);
            return new ResponseEntity<>("Deposit registered succesfully!", HttpStatus.ACCEPTED);
        } catch (Error e) {
            return new ResponseEntity<>(e.toString(),HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/withdraw", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> withdrawal(@RequestBody TransactionCase transactionCase) {
        try {
            accountService.withdraw(transactionCase.amount);
            return new ResponseEntity<>("Withdrawal registered succesfully!", HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>("something went wrong", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/statement")
    public ResponseEntity<Object> getStatement() {
        return new ResponseEntity<>(accountService.printStatement(), HttpStatus.OK);
    }
}

package com.example.demo.accountTests;

import com.example.demo.application.port.AccountService;
import com.example.demo.domain.entity.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class accountTests {

    @Autowired
    private AccountService accountService;

    @Test
    public void transferWithInvalidId() {
        Optional<Account> accountOptional = accountService.updateAcc(1000, "livretA", "current", 1000.0);
        assertFalse(accountOptional.isPresent());
    }

    @Test
    public void transferBalanceNotEnough() {
        Optional<Account> accountOptional = accountService.updateAcc(1, "livretA", "current", 100000.0);
        assertFalse(accountOptional.isPresent());
    }

    @Test
    public void transferSubAccNotExist() {
        Optional<Account> accountOptional = accountService.updateAcc(1, "lssssssivretA", "current", 100000.0);
        assertFalse(accountOptional.isPresent());
    }

    @Test
    public void transferSuccess() {
        Optional<Account> accountOptional = accountService.updateAcc(1, "livretA", "current", 1.0);
        assertTrue(accountOptional.isPresent());
    }
}

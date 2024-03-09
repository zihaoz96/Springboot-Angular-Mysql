package com.example.demo.accountTests;

import com.example.demo.domain.service.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class accountTests {

    @Autowired
    private AccountService accountService;

    @Test
    public void transferWithInvalidId() {
        String response = accountService.updateAcc(1000, "livretA", "current", 1000.0).getMessage();
        assertEquals("Invalid id", response);
    }

    @Test
    public void transferBalanceNotEnough() {
        String response = accountService.updateAcc(1, "livretA", "current", 100000.0).getMessage();
        assertEquals("Balance not enough", response);
    }

    @Test
    public void transferSubAccNotExist() {
        String response = accountService.updateAcc(1, "livressstA", "current", 100000.0).getMessage();
        assertEquals("Error account name", response);
    }
}

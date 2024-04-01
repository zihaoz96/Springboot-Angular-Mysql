package com.example.demo.userTests;

import com.example.demo.domain.service.UserService;
import com.example.demo.domain.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class userTests {

    @Autowired
    private UserService userService;

    @Test
    public void testSuccess(){
        String username = "admin";
        String password = "admin";

        Optional<User> userExist = userService.findUser(username,password);
        assertTrue(userExist.isPresent());
    }

    @Test
    public void testFailed(){
        String username = "testUser";
        String password = "testPassword";

        Optional<User> userExist = userService.findUser(username,password);
        assertFalse(userExist.isPresent());

    }
}

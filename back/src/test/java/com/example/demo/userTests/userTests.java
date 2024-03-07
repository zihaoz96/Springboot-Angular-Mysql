package com.example.demo.userTests;

import com.example.demo.domain.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class userTests {

    @Autowired
    private UserService userService;

    @Test
    public void testSuccess(){
        String username = "admin";
        String password = "admin";

        boolean userExist = userService.findUser(username,password);
        System.out.println(userExist);
    }

    @Test
    public void testFailed(){
        String username = "testUser";
        String password = "testPassword";

        boolean userExist = userService.findUser(username,password);
        System.out.println(userExist);
    }
}

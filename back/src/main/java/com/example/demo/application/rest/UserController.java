package com.example.demo.application.rest;

import com.example.demo.domain.service.UserService;
import com.example.demo.application.response.AjaxResponse;
import com.example.demo.domain.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(value = "*")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public AjaxResponse login(@RequestParam("username") String username, @RequestParam("password") String password) {
        System.out.println("Request login");

        Optional<User> user = userService.findUser(username, password);

        if(user.isPresent()){
            return AjaxResponse.success("Login success !");
        }

        return AjaxResponse.failed("Login failed");
    }
}

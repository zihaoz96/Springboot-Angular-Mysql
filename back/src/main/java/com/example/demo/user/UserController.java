package com.example.demo.user;

import com.example.demo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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

        boolean userExist = userService.findUser(username, password);

        if(userExist){
            return AjaxResponse.success("Login success !");
        }

        return AjaxResponse.failed("Login failed");
    }
}

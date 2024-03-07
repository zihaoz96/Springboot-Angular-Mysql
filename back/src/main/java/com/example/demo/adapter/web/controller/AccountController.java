package com.example.demo.adapter.web.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {


    @PostMapping("/transfer")
    public String transfer(@RequestParam("id") Integer id,
                           @RequestParam("fromAcc") String fromAcc,
                           @RequestParam("toAcc") String toAcc,
                           @RequestParam("amount") String amount){




        return "";
    }

}

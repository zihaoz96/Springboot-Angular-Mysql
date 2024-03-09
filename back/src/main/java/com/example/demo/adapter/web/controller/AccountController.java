package com.example.demo.adapter.web.controller;

import com.example.demo.application.AjaxResponse;
import com.example.demo.domain.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(value = "*")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    private AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    @PostMapping("/transfer")
    public AjaxResponse transfer(@RequestParam("id") Integer id,
                                 @RequestParam("fromAcc") String fromAcc,
                                 @RequestParam("toAcc") String toAcc,
                                 @RequestParam("amount") String amount){

        try{
            Double amountDouble = Double.parseDouble(amount);
            return accountService.updateAcc(id, fromAcc, toAcc, amountDouble);
        }catch (Exception e){
            return AjaxResponse.failed("Invalid param");
        }
    }
}

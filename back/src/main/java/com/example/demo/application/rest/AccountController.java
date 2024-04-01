package com.example.demo.application.rest;

import com.example.demo.domain.service.AccountService;
import com.example.demo.application.response.AjaxResponse;
import com.example.demo.domain.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

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
            Optional<Account> account = accountService.updateAcc(id, fromAcc, toAcc, amountDouble);
            return account.map(value -> AjaxResponse.success("Transfer success", value))
                    .orElseGet(() -> AjaxResponse.failed("Invalid param"));
        }catch (Exception e){
            return AjaxResponse.failed("Invalid param");
        }
    }
}

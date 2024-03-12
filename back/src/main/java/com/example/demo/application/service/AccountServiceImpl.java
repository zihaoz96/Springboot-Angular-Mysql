package com.example.demo.application.service;

import com.example.demo.application.port.AccountService;
import com.example.demo.domain.entity.Account;
import com.example.demo.domain.port.AccountRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepositoryPort accountRepositoryPort;

    @Autowired
    public AccountServiceImpl(AccountRepositoryPort accountRepositoryPort) {
        this.accountRepositoryPort = accountRepositoryPort;
    }

    @Override
    public Optional<Account> updateAcc(int id, String fromAcc, String toAcc, Double amount) {
        Optional<Account> account = accountRepositoryPort.findById(id);
        if(account.isPresent()){
            Account accountVal = account.get();
            Optional<Object> balanceFromOptional = accountVal.getFieldValue(fromAcc);
            Optional<Object> balanceToOptional = accountVal.getFieldValue(toAcc);
            if(balanceFromOptional.isPresent() && balanceToOptional.isPresent()){
                double balanceFrom = (double) balanceFromOptional.get();
                double balanceTo = (double) balanceToOptional.get();

                if(balanceFrom - amount < 0) return Optional.empty();

                accountVal.setFieldValue(fromAcc, balanceFrom-amount);
                accountVal.setFieldValue(toAcc, balanceTo+amount);
            }else{
                return Optional.empty();
            }
        }

        return account;
    }
}

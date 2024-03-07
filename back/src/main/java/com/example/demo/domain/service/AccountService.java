package com.example.demo.domain.service;

import com.example.demo.domain.model.Account;
import com.example.demo.port.persistence.AccountJpaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {
    private final AccountJpaRepository accountJpaRepository;

    @Autowired
    public AccountService(AccountJpaRepository accountJpaRepository) {
        this.accountJpaRepository = accountJpaRepository;
    }

    @Transactional
    public String updateAcc(int id, String fromAcc, String toAcc, double amount)  {
        Account account = accountJpaRepository.findById(id);

        if(account == null) return "Invalid id";

        Optional<Object> balanceFromOptional = account.getFieldValue(fromAcc);
        Optional<Object> balanceToOptional = account.getFieldValue(toAcc);
        if(balanceFromOptional.isPresent() && balanceToOptional.isPresent()){
            double balanceFrom = (double) balanceFromOptional.get();
            double balanceTo = (double) balanceToOptional.get();

            if(balanceFrom - amount < 0) return "Balance not enough";

            account.setFieldValue(fromAcc, balanceFrom-amount);
            account.setFieldValue(toAcc, balanceTo+amount);
        }else{
            return "Error account name";
        }

        return "Transferred";
    }
}

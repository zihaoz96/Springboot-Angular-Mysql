package com.example.demo.compte;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

@Service
public class AccountService {

    private final EntityManager entityManager;

    @Autowired
    public AccountService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public String updateAcc(int id, String fromAcc, String toAcc, double amount)  {
        Account account = entityManager.find(Account.class, id);

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

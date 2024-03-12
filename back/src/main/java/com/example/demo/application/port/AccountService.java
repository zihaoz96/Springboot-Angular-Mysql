package com.example.demo.application.port;

import com.example.demo.domain.entity.Account;

import java.util.Optional;

public interface AccountService {

    Optional<Account> updateAcc(int id, String fromAcc, String toAcc, Double amount);
}

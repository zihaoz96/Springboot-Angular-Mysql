package com.example.demo.domain.service;

import com.example.demo.domain.entity.Account;

import java.util.Optional;

public interface AccountService {

    Optional<Account> updateAcc(int id, String fromAcc, String toAcc, Double amount);
}

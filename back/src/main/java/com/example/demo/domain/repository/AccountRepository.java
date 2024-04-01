package com.example.demo.domain.repository;

import com.example.demo.domain.entity.Account;

import java.util.Optional;

public interface AccountRepository {
    Optional<Account> findById(int id);
}

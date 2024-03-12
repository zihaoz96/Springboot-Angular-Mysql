package com.example.demo.domain.port;

import com.example.demo.domain.entity.Account;

import java.util.Optional;

public interface AccountRepositoryPort {
    Optional<Account> findById(int id);
}

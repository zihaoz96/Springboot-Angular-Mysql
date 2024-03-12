package com.example.demo.infrastructure.repository;

import com.example.demo.domain.entity.Account;
import com.example.demo.domain.port.AccountRepositoryPort;
import com.example.demo.infrastructure.repository.jpa.AccountJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class AccountRepository implements AccountRepositoryPort {

    private final AccountJpaRepository accountJpaRepository;

    @Autowired
    public AccountRepository(AccountJpaRepository accountJpaRepository) {
        this.accountJpaRepository = accountJpaRepository;
    }

    @Override
    public Optional<Account> findById(int id) {
        return accountJpaRepository.findById(id);
    }
}

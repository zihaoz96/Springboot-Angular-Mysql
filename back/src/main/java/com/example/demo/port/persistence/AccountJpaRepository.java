package com.example.demo.port.persistence;

import com.example.demo.adapter.persistence.AccountRepository;
import com.example.demo.domain.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountJpaRepository extends JpaRepository<Account, Integer>, AccountRepository {
    @Override
    Account findById(int id);
}

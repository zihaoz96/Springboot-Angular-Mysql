package com.example.demo.adapter.persistence;

import com.example.demo.domain.model.Account;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository {
    Account findById(int id);
}

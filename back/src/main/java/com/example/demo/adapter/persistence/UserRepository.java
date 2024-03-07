package com.example.demo.adapter.persistence;

import com.example.demo.domain.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
    User findUser(String username, String password);
}

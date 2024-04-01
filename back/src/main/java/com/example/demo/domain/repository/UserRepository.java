package com.example.demo.domain.repository;

import com.example.demo.domain.entity.User;

import java.util.Optional;

/**
 * 出站端口
 *
 */
public interface UserRepository {
    Optional<User> findUser(String username, String password);
}

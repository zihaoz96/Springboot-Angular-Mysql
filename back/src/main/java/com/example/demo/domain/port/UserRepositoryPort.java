package com.example.demo.domain.port;

import com.example.demo.domain.entity.User;

import java.util.Optional;

/**
 * 出站端口
 *
 */
public interface UserRepositoryPort {
    Optional<User> findUser(String username, String password);
}

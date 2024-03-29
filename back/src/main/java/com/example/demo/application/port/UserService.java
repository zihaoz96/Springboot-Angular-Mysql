package com.example.demo.application.port;


import com.example.demo.domain.entity.User;

import java.util.Optional;

/**
 * 入站端口
 *
 */
public interface UserService {
    Optional<User> findUser(String username, String password);
}

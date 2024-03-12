package com.example.demo.application.service;

import com.example.demo.application.port.UserService;
import com.example.demo.domain.entity.User;
import com.example.demo.domain.port.UserRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepositoryPort userRepositoryPort;

    @Autowired
    public UserServiceImpl(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public Optional<User> findUser(String username, String password) {
        return this.userRepositoryPort.findUser(username, password);
    }
}

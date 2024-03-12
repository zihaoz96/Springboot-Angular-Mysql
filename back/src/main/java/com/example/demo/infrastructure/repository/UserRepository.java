package com.example.demo.infrastructure.repository;

import com.example.demo.domain.entity.User;
import com.example.demo.domain.port.UserRepositoryPort;
import com.example.demo.infrastructure.repository.jpa.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepository implements UserRepositoryPort {
    private final UserJpaRepository jpaUserRepository;

    @Autowired
    public UserRepository(UserJpaRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }

    @Override
    public Optional<User> findUser(String username, String password) {
        return jpaUserRepository.findUser(username, password);
    }
}

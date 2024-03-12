package com.example.demo.infrastructure.repository.jpa;

import com.example.demo.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<User, Integer> {

    @Query("SELECT u FROM User u WHERE u.username = :username AND u.password = :password")
    Optional<User> findUser(String username, String password);

    @Override
    <S extends User> S save(S entity);

}

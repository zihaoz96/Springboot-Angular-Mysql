package com.example.demo.port.persistence;

import com.example.demo.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepository extends JpaRepository<User, String> {

    @Query("SELECT u FROM User u WHERE u.username = :username AND u.password = :password")
    User findUser(String username, String password);
}

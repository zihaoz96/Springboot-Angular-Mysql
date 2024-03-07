package com.example.demo.domain.service;

import com.example.demo.domain.model.User;
import com.example.demo.port.persistence.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserJpaRepository userRepository;

    @Autowired
    public UserService(UserJpaRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean findUser(String username, String password){
        User userFind = userRepository.findUser(username, password);
        return userFind != null;
    }
}
